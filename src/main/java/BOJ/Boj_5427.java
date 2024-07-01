package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_5427 {
	static StringBuilder sb = new StringBuilder();
	static int[][] fireTime;
	static int[][] sangTime;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;

		while( n-- > 0 ){
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			char[][] building = new char[h][w];
			fireTime = new int[h][w];
			sangTime = new int[h][w];

			Queue<int[]> fire = new LinkedList<>();
			Queue<int[]> sanggeun = new LinkedList<>();

			for( int i = 0; i <  h; i++ ){

				String str = br.readLine();
				Arrays.fill( fireTime[i] , -1 );
				Arrays.fill( sangTime[i] , -1 );

				for( int j = 0 ; j < w ; j++ ){
					building[i][j] = str.charAt(j);

					if( building[i][j] == '@' ){
						sanggeun.add( new int[]{i,j} );
						building[i][j] = '.';
						sangTime[i][j] = 0;
					}else if( building[i][j] == '*' ){
						fire.add( new int[]{i,j} );
						fireTime[i][j] = 0;
					}
				}
			}

			bfs(building,fire,sanggeun,h,w);

		}
		System.out.println(sb);

	}
	private static void bfs( char[][] building , Queue<int[]> fire , Queue<int[]> sanggeun ,int h , int w ) {

		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};

		while( !fire.isEmpty() ){
			int[] now = fire.poll();

			for( int i = 0 ; i < 4; i++ ){
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];

				if( nx < 0|| ny <0 || nx >= h || ny >= w )
					continue;
				if( fireTime[nx][ny] >= 0 || building[nx][ny] == '#' )
					continue;

				fireTime[nx][ny] = fireTime[now[0]][now[1]] + 1;
				fire.add( new int[] {nx,ny});
			}
		}

		while( !sanggeun.isEmpty() ){

			int[] now = sanggeun.poll();

			for( int i = 0 ; i < 4; i++ ){
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];

				if( nx < 0 || ny < 0 || nx >= h || ny >= w ){
					sb.append( sangTime[now[0]][now[1]] +1  +"\n");
					return;
				}
				if( building[nx][ny] == '#' ||  fireTime[nx][ny] != -1 && fireTime[nx][ny] <= sangTime[now[0]][now[1]] + 1 )
					continue;

				if( sangTime[nx][ny] >= 0 )
					continue;


				sangTime[nx][ny] = sangTime[now[0]][now[1]] + 1;
				sanggeun.add(new int[]{nx,ny});

			}


		}

		sb.append( "IMPOSSIBLE\n");


	}
}
