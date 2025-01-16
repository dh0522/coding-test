package coding_study.graphandtraversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7576 {
	static Queue<int[]> q = new ArrayDeque<>();
	static int[][] visited;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int zero = 0;
		int[][] box = new int[n][m];
		visited = new int[n][m];

		for ( int i =0; i < n; i++ ){
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++ ){
				box[i][j] = Integer.parseInt(st.nextToken());
				if ( box[i][j] == 1 ) {
					q.add(new int[]{i, j});
					visited[i][j] = 1;
				}else if( box[i][j] == 0 )
					zero++;
			}
		}

		if (zero == 0){
			System.out.println(0);
			return;
		}


		System.out.println(bfs(box) -1);

	}
	private static int bfs(int[][] box){
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};

		int max = 0;
		while(!q.isEmpty()){
			int[] now = q.poll();
			for (int d = 0; d < 4; d++ ){
				int nx = now[0] + dx[d];
				int ny = now[1] + dy[d];

				if( nx < 0 || ny < 0 || nx >= box.length || ny >= box[0].length )
					continue;
				if( visited[nx][ny] != 0 )
					continue;
				if (box[nx][ny] == -1 )
					continue;

				q.add( new int[]{nx,ny} );
				visited[nx][ny] = visited[now[0]][now[1]] + 1;
				box[nx][ny] = 1;
				max = Math.max( max, visited[nx][ny] );
			}
		}
		for (int i =0; i < box.length; i++ ){
			for (int j =0; j < box[0].length; j++ ) {
				if( box[i][j] == 0 )
					return 0;
			}
		}

		return max;
	}
}
