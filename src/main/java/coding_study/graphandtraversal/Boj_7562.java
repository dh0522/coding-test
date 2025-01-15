package coding_study.graphandtraversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7562 {
	static int[] dx = {-2,-2,-1,-1,1,1,2,2};
	static int[] dy = {-1,1,-2,2,-2,2,-1,1};
	public static void main(String[] args) throws Exception {

		int len = 0;
		StringTokenizer st;
		int[] now = new int[2];
		int[] want = new int[2];
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0){
			len = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			now[0] = Integer.parseInt(st.nextToken());
			now[1] = Integer.parseInt(st.nextToken());


			st = new StringTokenizer(br.readLine());
			want[0] = Integer.parseInt(st.nextToken());
			want[1] = Integer.parseInt(st.nextToken());

			sb.append(bfs( len, now, want )).append("\n") ;
		}

		System.out.println(sb);
	}
	private static int bfs(int size, int[] now, int[] want){
		Queue<int[]> q = new ArrayDeque<>();
		int[][] visited = new int[size][size];

		visited[now[0]][now[1]] = 0;
		q.add(now);

		while (!q.isEmpty()){
			now = q.poll();

			if ( now[0] == want[0] && now[1] == want[1] ){
				return visited[want[0]][want[1]];
			}

			for (int d = 0; d < 8; d++ ){
				int nx = now[0] + dx[d];
				int ny = now[1] + dy[d];

				if( nx < 0 || ny < 0 || nx >= size || ny >= size )
					continue;
				if( visited[nx][ny] != 0) {
					continue;
				}

				visited[nx][ny] = visited[now[0]][now[1]] + 1;
				q.add( new int[]{nx,ny});
			}
		}
		return visited[want[0]][want[1]];
	}
}
