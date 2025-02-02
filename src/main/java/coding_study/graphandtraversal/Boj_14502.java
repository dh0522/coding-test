package coding_study.graphandtraversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_14502 {
	static int n, m;
	static int[][] virus;
	static int fullSafe = 0;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int answer = Integer.MIN_VALUE;
	static List<int[]> zero = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 0 = 빈칸, 1 = 벽, 2 = 바이러스
		virus = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				virus[i][j] = Integer.parseInt(st.nextToken());
				if (virus[i][j] == 0) {
					zero.add(new int[] {i, j});
					fullSafe++;
				}
			}
		}


		searchMax(0, 0 );
		System.out.println(answer);

	}

	private static void searchMax(int count, int idx) {

		if (count == 3) {
			// 벽을 다 세움
			spreadVirus();
			return;
		}

		for (int i = idx; i < zero.size(); i++) {
			virus[zero.get(i)[0]][zero.get(i)[1]] = 1;
			searchMax(count + 1, i +1 );
			virus[zero.get(i)[0]][zero.get(i)[1]] = 0;
		}

	}

	private static void spreadVirus() {

		int count = fullSafe;

		int[][] tempArr = new int[n][m];
		for (int i = 0; i < n; i++)
			tempArr[i] = virus[i].clone();

		// 바이러스 퍼지기
		Queue<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (virus[i][j] == 2) {
					q.add(new int[] {i, j});
				}
			}
		}

		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = now[0] + dx[d];
				int ny = now[1] + dy[d];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;

				// 이미 바이러스 이거나 벽이 있다면 돌아가
				if (tempArr[nx][ny] != 0 )
					continue;

				count--;
				tempArr[nx][ny] = 2;
				q.add(new int[] {nx, ny});
			}
		}

		answer = Math.max(answer, count - 3 );
	}
}
