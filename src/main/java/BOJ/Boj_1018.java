package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1018 {
	static int answer = Integer.MAX_VALUE;
	static String[] string = {"WBWBWBWB","BWBWBWBW"};
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		String[] board = new String[n];

		for( int i = 0 ; i < n ; i++ ){
			board[i] = br.readLine();
		}

		for( int i = 0; i <= n-8; i++ ){
			for( int j= 0; j <= m-8; j ++ ){
				calc( i , j , board );
			}
		}
		System.out.println(answer);
	}
	private static void calc( int startX, int startY, String[] board ){

		int diff = 0;
		// 0,0 == B
		for( int i = startX; i < startX + 8 ; i++ ){
			if( i % 2 == 0 ){
				String temp = board[i].substring(startY, startY+8);
				diff += compare(temp , string[1] );
			}
			else{
				String temp = board[i].substring(startY, startY+8);
				diff += compare(temp, string[0] );

			}
		}
		answer = Math.min( answer , diff );

		diff = 0;

		for( int i = startX; i < startX + 8 ; i++ ){
			if( i % 2 == 0 ){
				String temp = board[i].substring(startY, startY+8);
				diff += compare(temp , string[0] );
			}
			else{
				String temp = board[i].substring(startY, startY+8);
				diff += compare(temp, string[1] );


			}
		}
		answer= Math.min( answer , diff );

	}
	private static int compare( String first ,String second ){
		int num = 0 ;
		for( int i = 0 ;i < 8; i++ ){
			if( first.charAt(i) != second.charAt(i) )
				num++;
		}
		return num;
	}
}



















