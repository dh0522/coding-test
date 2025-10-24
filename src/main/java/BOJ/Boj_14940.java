package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_14940 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];
		int[] start = new int[2];
		List<int[]> zero = new ArrayList<>();
		// 0 = 갈 수 없는 땅, 1 = 갈 수 잇는 땅 , 2= 목표지점 (단 1개)
		for (int i = 0; i < n; i++ ){
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2){
					start[0] = i;
					start[1] = j;
				}else if(arr[i][j] == 0){
					zero.add(new int[]{i,j});
				}
			}
		}

		int[][] answer = searchMap(n, m, arr, start);
		for (int i = 0; i < zero.size(); i++){
			int x = zero.get(i)[0];
			int y = zero.get(i)[1];

			answer[x][y] = 0;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++){
			for (int j = 0; j < m; j++ ){
				sb.append(answer[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
	private static int[][] searchMap(int n, int m, int[][] arr, int[] start) {


		int[][] visited = new int[n][m];
		for (int i =0 ; i< n; i++){
			Arrays.fill(visited[i], -1);
		}


		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};

		Queue<int[]> q = new LinkedList<>();
		q.add(start);
		visited[start[0]][start[1]] = 0;
		// 원래 갈 수 없는 땅 -> 0
		// 갈 수 잇엇는데 도달할 수 없다면 -1

		while (!q.isEmpty()){
			int[] now = q.poll();

			for (int d = 0; d < 4; d++){
				int nx = now[0] + dx[d];
				int ny = now[1] + dy[d];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m )
					continue;

				if (arr[nx][ny] == 0){
					visited[nx][ny] = 0;
					continue;
				}

				if ( visited[nx][ny] != -1 )
					continue;

				visited[nx][ny] = visited[now[0]][now[1]] + 1;
				q.add(new int[]{nx,ny});
			}
		}

		return visited;

	}
}
