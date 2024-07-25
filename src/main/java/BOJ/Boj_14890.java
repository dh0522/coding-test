package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14890 {
	static int[][] arr;
	static int answer;
	static int n,l;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		arr = new int[n][n];

		for( int i =0 ; i <n ;i++ ){
			st = new StringTokenizer(br.readLine());
			for( int j =0; j< n ;j++ ){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for( int i =0; i< n ;i++ ){

			isRow( i );
			isColumn(i);
		}

		System.out.println(answer);
	}
	private static void isColumn( int column ){

		boolean[] put = new boolean[n];

		for( int i =0; i < n-1;i ++ ) {
			int diff = arr[i+1][column] - arr[i][column] ;
			if( Math.abs(diff) >= 2 )
				return;
			if( diff == 0 ) {
				continue;
			}
			// i < i+1 : 다음 것이 더 큼
			else if( diff == 1 ){

				for( int j = i; j > i-l; j-- ){
					if( j < 0 || j >= n )
						return;
					if( arr[i][column] != arr[j][column] )
						return;
					if( put[j] )
						return;
					put[j] = true;
				}

			}else if( diff == -1 ){
				for( int j = i+1; j <= i + l; j++ ){
					if( j < 0 || j >= n )
						return;
					if( arr[i+1][column] != arr[j][column] )
						return;
					if( put[j] )
						return;
					put[j] = true;
				}

				i = i+l-1;
			}

		}

		answer++;


	}
	private static void isRow(int row){

		boolean[] put = new boolean[n];

		for( int i =0; i < n-1;i ++ ) {
			int diff = arr[row][i+1] - arr[row][i] ;
			if( Math.abs(diff) >= 2 )
				return;
			if( diff == 0 ) {
				continue;
			}
			// i < i+1 : 다음 것이 더 큼
			else if( diff == 1 ){

				for( int j = i; j > i-l; j-- ){
					if( j < 0 || j >= n )
						return;
					if( arr[row][i] != arr[row][j] )
						return;
					if( put[j] )
						return;
					put[j] = true;
				}

			}else if( diff == -1 ){
				for( int j = i+1; j <= i + l; j++ ){
					if( j < 0 || j >= n )
						return;
					if( arr[row][i+1] != arr[row][j] )
						return;
					if( put[j] )
						return;
					put[j] = true;
				}

				i = i+l-1;
			}

		}

		answer++;


	}
}
