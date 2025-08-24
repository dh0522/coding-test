package BOJ.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_17142 {
	static int n,m;
	static int[][] arr;
	static boolean[] check;
	static int zeroCnt = 0;
	static int answer = Integer.MAX_VALUE;
	static List<int[]> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][n];

		for (int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2){
					list.add(new int[]{i,j});
				}else if (arr[i][j] == 0)
					zeroCnt++;
			}
		}

		if (zeroCnt == 0){
			System.out.println(0);
			return;
		}

		check = new boolean[list.size()];
		dfs(0, 0);

		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);


	}
	private static void dfs(int depth ,int start){
		if (depth == m){
			searchTime();
			return;
		}

		for (int i = start; i < check.length; i++){
			if (check[i])
				continue;

			check[i] = true;
			dfs(depth+1, i+1);
			check[i] = false;
		}

	}
	private static void searchTime(){

		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};

		int[][] tempArr = new int[n][n];
		for (int i = 0; i < n; i++){
			Arrays.fill(tempArr[i], -1);
		}

		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < check.length; i++){
			int[] virus = list.get(i);
			if (check[i]){
				q.add(virus);
				tempArr[virus[0]][virus[1]] = 0;
			}
		}

		// 1 = 벽
		int time = 0;
		int zero = 0;

		while(!q.isEmpty()){
			int[] now = q.poll();
			if (time >= answer)
				return;

			for (int d = 0; d < 4; d++){
				int nx = now[0] + dx[d];
				int ny = now[1] + dy[d];

				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;

				// 벽일때
				if (arr[nx][ny] == 1)
					continue;

				// 이미 지나갔거나, 바이러스가 활성화된 자리거나
				if (tempArr[nx][ny] != -1)
					continue;

				q.add(new int[] {nx,ny});
				tempArr[nx][ny] = tempArr[now[0]][now[1]] + 1;

				if (arr[nx][ny] == 0) {
					time = Math.max(time, tempArr[nx][ny]);
					if (time >= answer) return;
					zero++;
				}
			}
		}

		if (zero != zeroCnt)
			return;


		answer = Math.min(answer, time);
	}

}
