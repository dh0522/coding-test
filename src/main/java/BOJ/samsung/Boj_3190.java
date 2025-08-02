package BOJ.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_3190 {
	static int[][] board;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 보드 크기
		int n = Integer.parseInt(br.readLine());
		// 사과 개수
		int k = Integer.parseInt(br.readLine());

		board = new int[n][n];

		StringTokenizer st;
		for (int i = 0; i < k; i++ ){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;

			board[x][y] = 1;
		}

		// 뱀의 방향 전환
		int l = Integer.parseInt(br.readLine());
		int[][] rotation = new int[l][2];

		// 왼쪽으로 회전 = 1
		// 오른쪽으로 회전 = 2


		for(int i = 0; i < l; i ++){
			st = new StringTokenizer(br.readLine());
			rotation[i][0] = Integer.parseInt(st.nextToken());
			String tmp = st.nextToken();
			if (tmp.equals("L")){
				rotation[i][1] = 1;
			}else{
				rotation[i][1] = 2;
			}
		}

		int answer = 0;
		int rotate = 0;
		int d = 0;

		Deque<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];

		visited[0][0] = true;
		q.addFirst(new int[]{0,0});

		while(!q.isEmpty()) {

			// 앞으로 직진해야 할 애
			int[] now = q.pollFirst();

			int nx = now[0] + dx[d];
			int ny = now[1] + dy[d];

			answer++;

			// 1. 벽에 부딪힘
			if (nx < 0 || ny < 0 || nx >= n || ny >= n)
				break;

			// 2. 자기 자신에 부딪힘
			if (visited[nx][ny])
				break;

			// 앞으로 가려는 놈

			visited[nx][ny] = true;

			// 이제 뒤에 애를 없애야 함.
			// 사과가 있다면 길이를 늘리기
			if (board[nx][ny] == 1) {
				board[nx][ny] = 0;
				q.addFirst(now);
			} else {
				// 사과가 없다면
				if (!q.isEmpty()) {
					int[] tmp = q.pollLast();
					visited[tmp[0]][tmp[1]] = false;
					q.addFirst(now);
				} else {
					visited[now[0]][now[1]] = false;
				}
			}
			q.addFirst(new int[] {nx, ny});

			if (rotate < l && rotation[rotate][0] == answer) {
				if (rotation[rotate][1] == 2)
					d = (d + 1) % 4;
				else
					d = d - 1 == -1 ? 3 : d - 1;
				rotate++;
			}

		}
		System.out.println(answer);


	}

}
