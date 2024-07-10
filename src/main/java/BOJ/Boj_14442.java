package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Boj_14442 {
	private static class pair{
		int x, y, depth,dist;
		public pair( int x, int y, int depth, int dist ){
			this.x = x;
			this.y = y;
			this.depth = depth;
			this.dist = dist;
		}
	}
	static int answer= -1;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		char[][] map = new char[n][m];

		for( int i = 0 ; i <n ; i++ ){
			String str = br.readLine();
			map[i] = str.toCharArray();
		}

		bfs(map,n,m,k);
		System.out.println(answer);
	}
	private static void bfs( char[][] map , int n, int m , int k ){

		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};

		Queue<pair> q = new LinkedList<>();
		q.add(new pair(0,0,0,1));

		boolean[][][] visited = new boolean[n][m][k+1];
		visited[0][0][0] = true;

		while( !q.isEmpty() ){
			pair now = q.poll();

			int x = now.x;
			int y = now.y;
			int depth = now.depth;
			int dist = now.dist;

			if( x == n-1 && y == m-1 ){
				answer = dist;
				return;
			}

			for( int i = 0 ; i < 4; i++ ){
				int nx = x + dx[i];
				int ny = y + dy[i];

				if( nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny][depth] )
					continue;

				if( map[nx][ny] == '0' ){
					visited[nx][ny][depth]= true;
					q.add(new pair(nx,ny,depth,dist+1));
				}
				else if( depth < k && map[nx][ny] == '1' && !visited[nx][ny][depth+1] ) {
					// depth < k && 다음이 1 인 경우
					q.add(new pair(nx,ny,depth+1,dist+1));
					visited[nx][ny][depth+1]= true;

				}
			}

		}
	}
}
