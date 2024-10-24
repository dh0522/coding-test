package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16937 {
	static int h,w,n;
	static int[][] sticker;
	static int answer = 0;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(br.readLine());

		sticker = new int[n][2];

		for ( int i=0; i < n; i++ ){
			 st = new StringTokenizer(br.readLine());
			 sticker[i][0] = Integer.parseInt(st.nextToken());
			 sticker[i][1] = Integer.parseInt(st.nextToken());
		}

		first();
		System.out.println( answer );
	}
	private static void first(){

		for ( int i=0; i < n; i++ ){

			int x = sticker[i][0];
			int y = sticker[i][1];

			if( x <= w && y <= h )
				second( w-x, h-y, i );

			if( x <= h && y <= w )
				second( w-y , h-x , i );

		}
	}
	private static void second( int newX , int newY , int idx ){

		for ( int i = idx+1; i< n; i++ ){

			int nowX = sticker[i][0];
			int nowY = sticker[i][1];

			if( nowX <= newX && nowY <= h )
				answer = Math.max( answer , sticker[idx][0]*sticker[idx][1] + sticker[i][0]*sticker[i][1] );

			if (nowX <= w && nowY <= newY )
				answer = Math.max( answer ,sticker[idx][0]*sticker[idx][1] + sticker[i][0]*sticker[i][1] );

			if( nowX <= h && nowY <= newX )
				answer = Math.max( answer , sticker[idx][0]*sticker[idx][1] + sticker[i][0]*sticker[i][1] );

			if ( nowX <= newY && nowY <= w )
				answer = Math.max( answer , sticker[idx][0]*sticker[idx][1] + sticker[i][0]*sticker[i][1] );

		}


	}

}
