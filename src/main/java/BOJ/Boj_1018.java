package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1018 {

	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean[][] board = new boolean[n][m];
		for( int i = 0 ; i < n; i++ ){
			String temp = br.readLine();
			for( int j = 0 ;j < m; j++ ){
				if( temp.charAt(j) == 'B' )
					board[i][j] = true;
				else board[i][j] = false;
			}

		}

		int garo = n-7;
		int sero = m-7;

		for(int i = 0; i< garo; i++ ){
			for( int j = 0 ; j < sero ; j++ )
				search( board , i , j );
		}
		System.out.println(answer);
	}
	public static void search( boolean [][] board , int garo , int sero ){

		boolean first = board[garo][sero];
		int num = 0;

		for( int i = garo; i < garo+8; i++ ){
			for( int j = sero; j < sero+8; j++ ){

				if( board[i][j] != first )
					num++;

				first = !first;
			}
			first = !first;

		}
		num = 0;
		first = !board[garo][sero];
		for( int i = garo; i < garo+8; i++ ){
			for( int j = sero; j < sero+8; j++ ){

				if( board[i][j] != first )
					num++;

				first = !first;
			}
			first = !first;

		}
		answer = Math.min( answer , num );

	}
}
