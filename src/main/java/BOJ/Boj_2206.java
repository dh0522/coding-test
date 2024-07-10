package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2206 {
	static int answer = -1;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][][] map = new int[2][n][m];
		for( int i = 0 ; i < n ;i ++ ){
			String str = br.readLine();
			for( int j = 0 ; j < m; j++ ){
				map[0][i][j] = Integer.parseInt( str.charAt(j)+"" );
			}
		}


		bfs( map , n , m );
		System.out.println(answer);
	}
	private static void bfs( int[][][] map , int n , int m ){

		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{0,0,0});

		int[][][] visited = new int[2][n][m];
		visited[0][0][0] = 1;

		while( !q.isEmpty() ){

			int[] now = q.poll();
			int depth = now[0];
			int x = now[1];
			int y = now[2];

			if( x == n-1 && y == m-1 ){
				answer = visited[depth][x][y];
				return;
			}

			for( int i = 0; i < 4; i++ ){
				int nx = x + dx[i];
				int ny = y + dy[i];

				if( nx < 0 || ny < 0 || nx >=n || ny >=m )
					continue;

				if( visited[depth][nx][ny] != 0 )
					continue;

				if( depth == 1 && map[0][nx][ny] == 1 )
					continue;

				if( map[0][nx][ny] == 1 ){
					q.add(new int[]{ 1, nx, ny });
					visited[1][nx][ny] = visited[depth][x][y] + 1;
					continue;
				}

				q.add(new int[]{depth, nx, ny });
				visited[depth][nx][ny] = visited[depth][x][y] + 1;
			}
		}
		return;
	}
}
