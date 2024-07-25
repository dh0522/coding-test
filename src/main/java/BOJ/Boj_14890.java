package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14890 {
	static int n,l;
	static int[][] arr;
	static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		arr = new int[n][n];


		for( int i =0; i <n ; i++ ){
			st = new StringTokenizer(br.readLine());
			for( int j= 0; j < n; j ++ )
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

		for( int i = 0; i< n ; i++){
			isRow(i);
			isColumn(i);

		}
		System.out.println(answer);

	}
	private static void isColumn( int column ){
		boolean[] put = new boolean[n];

		for( int i = 0; i <n-1; i++ ){

			int diff = arr[i+1][column] - arr[i][column];
			if( diff == 0 )
				continue;
			if( Math.abs(diff) >= 2 )
				return;

			if( diff == 1 ){

				for( int j = i; j > i-l; j-- ){
					if( j < 0 || j >= n )
						return;
					if( put[j] )
						return;
					if( arr[j][column] != arr[i][column] )
						return;

					put[j] = true;
				}

			}else if( diff == -1 ){

				for( int j = i+1; j <= i + l ; j++ ){
					if( j < 0 || j >= n )
						return;
					if( put[j] )
						return;
					if( arr[j][column] != arr[i+1][column] )
						return;

					put[j] = true;
				}
				i =i+l-1;

			}

		}
		answer++;

	}
	private static void isRow( int row ){

		boolean[] put = new boolean[n];

		for( int i =0; i< n-1; i++ ){

			int diff = arr[row][i+1] - arr[row][i];

			if( diff == 0 )
				continue;
			if( Math.abs(diff) >= 2 )
				return;

			// i <  i+1
			if( diff == 1 ){

				for( int j = i; j > i-l ; j --){
					if( j < 0 || j >= n )
						return;
					if( put[j] )
						return;
					if( arr[row][j] != arr[row][i] )
						return;
					put[j] = true;
				}

			}
			else if( diff == -1 ){ // i > i+1

				for( int j = i+1; j <= i +l; j++ ){

					if( j < 0 || j >= n )
						return;
					if( put[j] )
						return;
					if( arr[row][j] != arr[row][i+1] )
						return;

					put[j] = true;

				}
				i = i + l-1;
			}
		}

		answer++;
	}
}
