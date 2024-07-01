package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_4179 {
	static char[][] miro;
	static int[][] fire;
	static int[][] jihoon;
	static Queue<int[]> fireQ = new LinkedList<>();
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		miro = new char[r][c];
		fire = new int[r][c];
		jihoon = new int[r][c];

		for( int i =0 ; i< r; i++ ){

			String str = br.readLine();

			Arrays.fill( fire[i] , -1 );
			Arrays.fill( jihoon[i],-1);

			for( int j = 0 ;j < c; j++ ){
				miro[i][j] = str.charAt(j);
				if( miro[i][j] == 'J' ){
					jihoon[i][j] = 0;
					q.add(new int[]{i,j});

					miro[i][j] = '.';

				}else if( miro[i][j] == 'F' ) {
					fire[i][j] = 0;
					fireQ.add( new int[]{i,j});
				}

			}
		}
		bfs(r,c);
	}
	private static void bfs( int r , int c ){
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};

		while( !fireQ.isEmpty() ){

			int[] now = fireQ.poll();
			int x = now[0];
			int y = now[1];

			for (int i = 0 ; i < 4; i++ ) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= r || ny >= c)
					continue;

				if ( fire[nx][ny] >= 0 || miro[nx][ny] == '#' )
					continue;

				fire[nx][ny] = fire[x][y] + 1;
				fireQ.add(new int[] {nx, ny});

			}
		}

		while( !q.isEmpty() ){
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];

			if( x == r-1 || y == c-1 || x == 0 || y == 0 ){
				System.out.println( jihoon[x][y] + 1 );
				return ;
			}

			for (int i = 0 ; i < 4; i++ ){
				int nx = x + dx[i];
				int ny = y + dy[i];

				if( nx < 0 || ny < 0 || nx >= r || ny >= c )
					continue;

				if( miro[nx][ny] == '#' || jihoon[nx][ny] >= 0 )
					continue;

				if( fire[nx][ny] != -1 && fire[nx][ny] <= jihoon[x][y] + 1 )
					continue;

				jihoon[nx][ny] = jihoon[x][y] + 1;
				q.add(new int[]{nx,ny});

			}
		}
		System.out.println("IMPOSSIBLE");
		return;
	}
}

