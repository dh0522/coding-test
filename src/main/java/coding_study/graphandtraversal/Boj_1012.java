package coding_study.graphandtraversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1012 {
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][] visited;
	static int[][] ground;
	public static void main(String[] args) throws Exception {

		int x, y;
		int m, n, k ;
		int count = 0;

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while( t-- > 0){
			st = new StringTokenizer(br.readLine());

			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			count = 0;
			ground = new int[n][m];
			visited = new boolean[n][m];

			while(k-- > 0){
				st = new StringTokenizer(br.readLine());

				y = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken());

				ground[x][y] = 1;
			}

			for ( int i =0; i < n; i++ ){
				for(int j=0; j < m; j++ ){
					if( visited[i][j] )
						continue;
					if( ground[i][j] == 0 )
						continue;

					bfs( i, j );
					count++;
				}
			}

			sb.append(count).append("\n");
		}

		System.out.println(sb);
	}
	private static void bfs(int x, int y){

		int nx = x;
		int ny = y;
		Queue<int[]> q = new ArrayDeque<>();
		int[] now = {0,0};

		q.add(new int[]{x,y});
		visited[x][y] = true;

		while(!q.isEmpty()){
			now = q.poll();

			for ( int d = 0; d < 4; d++ ){
				nx = now[0] + dx[d];
				ny = now[1] + dy[d];

				if ( nx < 0 || ny < 0 || nx >= ground.length || ny >= ground[0].length )
					continue;
				if (visited[nx][ny])
					continue;
				if (ground[nx][ny] == 0)
					continue;

				visited[nx][ny] = true;
				q.add( new int[]{nx,ny});
			}

		}
	}
}
