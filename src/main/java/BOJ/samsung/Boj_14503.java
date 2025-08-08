package BOJ.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_14503 {
	static int[] dx = {-1,0,1,0};// 북 동 남 서
	static int[] dy = {0,1,0,-1};
	static int n, m;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int nowX = Integer.parseInt(st.nextToken());
		int nowY = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());

		int[][] room = new int[n][m];
		for (int i = 0; i < n; i++ ){
			st = new StringTokenizer(br.readLine());
			for (int j =0 ; j < m; j++ ){
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = cleanRoom(room, nowX, nowY, dir);

		System.out.println(answer);
	}
	private static int cleanRoom(int[][] room, int x, int y, int dir){

		Queue<int[]> q= new LinkedList<>();
		q.add(new int[]{x,y});

		boolean[][] visited = new boolean[n][m];


		int cnt = 1;

		// 0 = 청소X , 1= 벽, 2 = 청소됨
		while(!q.isEmpty()) {

			int[] now = q.poll();
			room[now[0]][now[1]] = 2;

			visited[now[0]][now[1]] = true;

			boolean notClean = false;

			for (int d = 0; d < 4; d++) {
				dir = (dir - 1) == -1 ? 3 : dir - 1;

				int nx = now[0] + dx[dir];
				int ny = now[1] + dy[dir];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny])
					continue;

				// 청소되지 않은 빈칸이 있는 경우
				if (room[nx][ny] == 0) {
					cnt++;
					q.add(new int[] {nx, ny});
					notClean = true;
					break;
				}
			}

			if (!notClean) {
				int nx = now[0] - dx[dir];
				int ny = now[1] - dy[dir];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m || room[nx][ny] == 1)
					break;

				q.add(new int[] {nx, ny});
				if (room[nx][ny] == 0)
					cnt++;

			}

		}







		return cnt;
	}
}
