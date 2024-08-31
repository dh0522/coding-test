package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_17779 {
	static int[][] arr;
	static int n;
	static int answer = Integer.MAX_VALUE;
	static int allNumber = 0;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];

		StringTokenizer st;
		for(int i =0; i <n ;i ++ ){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j < n; j++ ){
				arr[i][j] = Integer.parseInt(st.nextToken());
				allNumber += arr[i][j];
			}
		}

		for( int x = 0; x < n-2 ; x++ ){
			for( int y = 1; y < n-1; y++ ){
				for( int d1 = 1; d1 <n; d1++ ){
					for( int d2 = 1; d2 <n; d2++ ){
						if( x + d1 + d2 >= n || y-d1 < 0 || y+d2 >= n )
							continue;
						createArea(x,y,d1,d2);
					}
				}
			}
		}

		System.out.println(answer);

	}
	private static void createArea( int x, int y , int d1, int d2 ){
		boolean[][] five = new boolean[n][n];

		for( int i= 0 ; i <= d1; i++ ){
			five[x+i][y-i]= true;
			five[x+d2+i][y+d2-i] = true;
		}

		for( int i=0; i <= d2; i++ ){
			five[x+i][y+i] = true;
			five[x+d1+i][y-d1+i] = true;
		}

		int[] sum = new int[5];
		for (int i = 0; i < x + d1; i++) {
			for (int j = 0; j <= y; j++) {
				if( five[i][j] )
					break;
				sum[0] += arr[i][j];
			}
		}


		for (int i = 0; i <= x + d2; i++) {
			for (int j = n - 1; j > y; j--) {
				if( five[i][j] )
					break;
				sum[1] += arr[i][j];
			}
		}

		for (int i = x + d1; i < n; i++) {
			for (int j = 0; j < y - d1 + d2; j++) {
				if( five[i][j] )
					break;
				sum[2] += arr[i][j];
			}
		}

		for (int i = x + d2 + 1; i < n; i++) {
			for (int j = n - 1; j >= y - d1 + d2; j--) {
				if( five[i][j] )
					break;
				sum[3] += arr[i][j];
			}
		}

		sum[4] = allNumber -( sum[0]+sum[1]+sum[2]+sum[3]);
		Arrays.sort( sum );
		answer = Math.min( answer , sum[4]- sum[0] );

	}
}
