package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17144 {
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] dust;
	static int r,c;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		dust = new int[r][c];
		int machineRow = -1 ;
		for( int i=0 ; i < r; i ++ ){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++ ) {
				dust[i][j] = Integer.parseInt(st.nextToken());
				if( dust[i][j] == -1 ){
					machineRow = i;
				}

			}
		}

		while( t-- > 0 ){

			spread();
			aircondition(machineRow);
		}

		int answer = 0;
		for( int i =0 ; i< r ;i ++ ){
			for( int j =0 ;j <c; j++ ) {
				if( dust[i][j] == -1 )
					continue;
				answer += dust[i][j];
			}
		}

		System.out.println(answer);

	}
	private static void spread(){

		int[][] tmp = new int[r][c];

		for( int i =0 ; i< r;i++ ){
			for( int j=0; j< c; j++ ){
				if( dust[i][j] == -1 )
					continue;

				for( int d= 0; d < 4; d ++ ){
					int nx = i + dx[d];
					int ny = j + dy[d];

					if( nx < 0 || ny < 0 || nx >= r || ny >= c )
						continue;
					if( dust[nx][ny] == -1 )
						continue;

					tmp[nx][ny] += dust[i][j]/5;
					tmp[i][j] -= dust[i][j]/5;
				}
			}
		}
		for( int i= 0 ; i< r; i++ ) {
			for( int j =0 ;j < c; j++ )
				dust[i][j] += tmp[i][j];
		}

	}
	private static void aircondition( int machineRow ){

		int x = machineRow-1;
		int y = 0;

		for( int i = x-1; i > 0; i -- ){
			dust[i][0] = dust[i-1][0];
		}
		for( int i= 1; i < c; i++ ){
			dust[0][i-1] = dust[0][i];
		}
		for( int i = 0; i < x; i++ ){
			dust[i][c-1] = dust[i+1][c-1];
		}
		for( int i = c-1; i > y  ; i -- ){
			dust[x][i] = dust[x][i-1];
		}
		dust[x][y+1] = 0;


		x = machineRow;
		y = 0;

		for( int i = x+1; i < r-1 ; i++ ){
			dust[i][0] = dust[i+1][0];
		}
		for( int i = 0; i < c-1  ; i++ ){
			dust[r-1][i] = dust[r-1][i+1];
		}
		for( int i = r-1; i > x  ; i-- ){
			dust[i][c-1] = dust[i-1][c-1];
		}
		 for( int i = c-1 ; i> 0 ; i-- )
		 	dust[x][i]= dust[x][i-1];
		dust[x][y+1] = 0;

	}

}
