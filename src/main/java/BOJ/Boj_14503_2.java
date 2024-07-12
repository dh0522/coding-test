package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14503_2 {
	static int answer = 0;
	static int[][] room;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static boolean possible = true;
	static int r , c, dir;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		room = new int[n][m];

		st = new StringTokenizer(br.readLine());
		r  = Integer.parseInt(st.nextToken());
		c  = Integer.parseInt(st.nextToken());
		dir  = Integer.parseInt(st.nextToken());

		for( int i =0 ; i <n ; i++ ){
			st = new StringTokenizer(br.readLine());
			for( int j = 0 ; j < m ; j++ ){
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while( possible ){

			if( room[r][c] == 0 ){
				answer++;
				room[r][c] = 2;
			}

			clean(  r, c , dir );

		}

		System.out.println(answer);


	}
	private static void clean( int x , int y , int d ){


		boolean exist = false;
		for( int i=0; i< 4; i++ ){

			int nx = x + dx[i];
			int ny = y + dy[i];

			if( nx < 0 || ny < 0 || nx >= room.length || ny >= room[0].length )
				continue;

			if( room[nx][ny] == 0 ){
				exist = true;
			}
		}

		if( exist ){

			int num = 4;
			while( num-- > 0){
				d = d-1 >=0 ? d-1 : 3;
				int nx = x + dx[d];
				int ny = y + dy[d];

				if( room[nx][ny] == 0 ) {
					r = nx;
					c = ny;
					dir = d;
					return;
				}
			}
		}

		else if( !exist ){

			int nx = x - dx[d];
			int ny = y - dy[d];

			// 벽 이면 작동 멈추기
			if( nx < 0 || ny < 0 || nx >= room.length || ny >= room[0].length || room[nx][ny] == 1 	){
				possible = false;
				return;
			}

			// 한 칸 후진

			r = nx;
			c = ny;
			dir = d;
			return;

		}

	}
}
