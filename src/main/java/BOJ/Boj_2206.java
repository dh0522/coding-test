package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2206 {
	static int[][] map;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int n,m;
	static int answer = -1;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for( int i = 0 ; i < n ; i++ ){
			String str = br.readLine();
			for( int j = 0 ;j < m ;j ++ ){
				map[i][j] = Integer.parseInt( str.charAt(j)+"" );
			}
		}

		bfs();
		System.out.println(answer);

	}
	private static void bfs(){

		Queue<int[]> q = new LinkedList<>();
		q.add( new int[]{0,0,0} );

		int[][][] visited = new int[2][n][m];
		visited[0][0][0] = 1;

		while( !q.isEmpty() ){

			int[] now = q.poll();

			int wall = now[0];
			int x = now[1];
			int y = now[2];

			if( x == n-1 && y == m-1 ){
				answer = visited[wall][x][y];
				return;
			}

			for( int i = 0 ; i < 4; i++ ){

				int nx = x + dx[i];
				int ny = y + dy[i];

				if( nx < 0 || ny < 0 || nx >= n || ny >= m )
					continue;

				// 벽이 없을때
				if( map[nx][ny] == 0 ){
					if( visited[wall][nx][ny] == 0 ) {
						visited[wall][nx][ny] = visited[wall][x][y] + 1;
						q.add(new int[] {wall, nx, ny});
					}
				}
				// 벽이 있을 때
				else {
					if( wall == 0 ){
						if( visited[1][nx][ny] == 0 ){
							visited[1][nx][ny] = visited[wall][x][y] + 1;
							q.add(new int[]{1,nx,ny});
						}

					}

				}

			}

		}
		return;
	}

}
