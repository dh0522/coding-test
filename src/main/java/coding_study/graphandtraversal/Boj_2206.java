package coding_study.graphandtraversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2206 {
	static char[][] arr;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new char[n][m];

		for (int i = 0; i < n; i++ ){
			String line = br.readLine();
			arr[i] = line.toCharArray();
		}

		bfs(n, m);
	}
	private static void bfs(int n, int m){

		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};

		Queue<int[]> q = new ArrayDeque<>();
		int[][][] visited = new int[2][n][m];


		visited[0][0][0] = 1;
		q.add(new int[]{0,0,0});

		int answer = Integer.MAX_VALUE;

		while(!q.isEmpty()){
			int[] now = q.poll();
			if ( now[1] == (n-1) && now[2] == (m-1) ){
				answer = Math.min(answer, visited[now[0]][now[1]][now[2]] );
			}

			for (int d = 0; d < 4; d++ ){
				int nx = now[1] + dx[d];
				int ny = now[2] + dy[d];

				if( nx < 0 || ny < 0 || nx >= n || ny >= m ) {
					continue;
				}

				if (arr[nx][ny]== '1' && now[0] == 1) {
					continue;
				}

				if ( visited[now[0]][nx][ny]  != 0 ) {
					continue;
				}
				if ( arr[nx][ny] == '1' ){

					q.add( new int[]{1,nx,ny} );
					visited[1][nx][ny] = visited[0][now[1]][now[2]] + 1;
					continue;

				}

				//앞으로 갈 수 있는 경우
				q.add( new int[]{now[0],nx,ny} );
				visited[now[0]][nx][ny] = visited[now[0]][now[1]][now[2]] + 1;



			}
		}

		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer );

	}
}
