package BOJ.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_14502 {
	static int[][] arr;
	static int n,m;
	static int answer = Integer.MIN_VALUE;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];

		for (int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		// 0 = 빈칸, 1 = 벽, 2 = 바이러스
		dfs(0,0, 0);

		System.out.println(answer);

	}
	private static void dfs(int x, int y, int cnt){
		if (cnt == 3){
			virus();
			return;
		}

		for (int i = 0; i < n; i++){
			for (int j = 0; j < m; j++ ){
				if ( arr[i][j] == 0 ){
					arr[i][j] = 1;
					dfs(i,j, cnt+1);
					arr[i][j] = 0;
				}
			}
		}
	}
	private static void virus(){
		// virus 퍼지기
		int[][] tmp = new int[n][m];
		for (int i =0; i < n; i ++){
			tmp[i] = arr[i].clone();
		}

		boolean[][] visited = new boolean[n][m];

		for (int i = 0; i < n; i++){
			for (int j = 0; j < m; j++ ){

				// virus가 있고, 방문하기 전인 지역
				if ( tmp[i][j] == 2 && !visited[i][j] ){

					Queue<int[]> q = new LinkedList<>();
					q.add(new int[]{i,j});
					visited[i][j] = true;

					while(!q.isEmpty()){
						int[] now = q.poll();

						for (int d = 0; d < 4; d ++ ){
							int nx = now[0] + dx[d];
							int ny = now[1] + dy[d];

							if (nx < 0 || ny< 0 || nx >= n || ny >= m)
								continue;

							if (tmp[nx][ny] == 1 || tmp[nx][ny] == 2)
								continue;

							if (visited[nx][ny])
								continue;

							visited[nx][ny] = true;
							tmp[nx][ny] = 2;

							q.add(new int[] {nx,ny});
						}

					}


				}
			}
		}

		// virus가 다 퍼졌으니 안전 영역 찾기
		int cnt = 0;
		for (int i = 0;  i < n; i ++){
			for (int j =0;j  < m; j ++ ){
				if (tmp[i][j] == 0)
					cnt++;
			}
		}

		answer = Math.max(answer, cnt);
	}

}







