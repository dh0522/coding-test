package coding_study.graphandtraversal;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2178 {
	static char[][] miro;
	static int[][] visited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		miro = new char[n][m];
		visited = new int[n][m];

		for (int i = 0; i < n; i++ ){
			miro[i] = br.readLine().toCharArray();
		}

		System.out.println(bfs());

	}
	private static int bfs(){

		Queue<int[]> q = new ArrayDeque<>();
		q.add( new int[]{0,0} );
		visited[0][0] = 1;

		int nx = 0;
		int ny = 0;
		int[] now = {0,0};

		while(!q.isEmpty()){
			now = q.poll();

			for (int d =0; d < 4; d++ ){
				nx = now[0] + dx[d];
				ny = now[1] + dy[d];

				if (nx < 0 || ny < 0 || nx >= miro.length || ny >= miro[0].length )
					continue;

				if( miro[nx][ny] == '0' )
					continue;

				if( visited[nx][ny] != 0 )
					continue;

				visited[nx][ny] = visited[now[0]][now[1]] + 1;
				q.add( new int[]{nx,ny} );

			}
		}

		return visited[ visited.length-1][visited[0].length-1];

	}
}
