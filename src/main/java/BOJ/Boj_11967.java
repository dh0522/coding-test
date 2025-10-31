package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_11967 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<Room>[][] map = new List[n+1][n+1];

		for (int i =1 ; i <= n; i++ ){
			for (int j =1; j <= n; j++){
				map[i][j] = new ArrayList<>();
			}
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map[x][y].add(new Room(a,b));
		}

		int answer = bfs(map, n);

		System.out.println(answer);

	}
	private static int bfs(List<Room>[][] map, int n){

		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};

		// 1. 불 킨 방
		boolean[][] isLight = new boolean[n+1][n+1];

		// 2. 방문해서 진짜로 불을 킨 배열
		boolean[][] visited = new boolean[n+1][n+1];

		// 3. 방문할 수 있는지
		boolean[][] canVisited = new boolean[n+1][n+1];


		int answer = 1;

		Queue<Room> q = new LinkedList<>();
		q.add(new Room(1,1));

		canVisited[1][1] = true;
		visited[1][1] = true;
		isLight[1][1] = true;

		while(!q.isEmpty()){
			Room now = q.poll();

			int nowx = now.x;
			int nowy = now.y;

			// 1. 현재 위치에서 갈 수 있는곳 체크
			for (int d = 0; d< 4; d++){
				int nx = nowx + dx[d];
				int ny = nowy + dy[d];

				if (nx < 1 || ny < 1|| nx >= n+1 || ny >= n+1)
					continue;

				canVisited[nx][ny] = true;
			}

			// 불을 킬 수 있는지 체크하고
			// 불을 킬 수 있고 지금 방문 가능하면 Q에 넣는다.
			for (int i = 0; i < map[nowx][nowy].size(); i++) {
				Room poss = map[nowx][nowy].get(i);

				if (!isLight[poss.x][poss.y] ) {
					isLight[poss.x][poss.y] = true;
					answer++;
				}

				if (canVisited[poss.x][poss.y] && !visited[poss.x][poss.y]){
					visited[poss.x][poss.y] = true;
					q.add(poss);
				}

			}

			for (int d = 0; d< 4; d++){
				int nx = nowx + dx[d];
				int ny = nowy + dy[d];

				if (nx < 1 || ny < 1|| nx >= n+1 || ny >= n+1)
					continue;

				if (isLight[nx][ny] && !visited[nx][ny]){
					visited[nx][ny] = true;
					q.add(new Room(nx,ny));
				}

			}


		}
		return answer;

	}
}

class Room  {
	int x;
	int y;
	public Room(int x, int y){
		this.x = x;
		this.y = y;
	}
}



