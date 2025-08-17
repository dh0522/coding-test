package BOJ.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16236 {
	static int n;
	static int[][] place;
	static int answer = 0;
	static int eatFish = 0;
	static int babySize = 2;
	static int[] shark = new int[2];
 	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static List<Fish> fishList;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		place = new int[n][n];

		for (int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++){
				place[i][j] = Integer.parseInt(st.nextToken());
				if (place[i][j] == 9){
					// 아기상어 위치
					shark[0] = i;
					shark[1] = j;

					place[i][j] = 0;
				}
			}
		}

		while(true){
			fishList = new ArrayList<>();
			searchFish();

			if (fishList.isEmpty())
				break;

			Collections.sort(fishList);
			Fish eat = fishList.get(0);

			shark[0] = eat.x;
			shark[1] = eat.y;

			place[eat.x][eat.y] = 0;

			eatFish++;
			answer += (eat.distance-1);


			// 먹은 물고기 수가 같으면
			if (eatFish == babySize){
				eatFish = 0;
				babySize++;
			}

		}

		System.out.println(answer);
	}
	private static void searchFish(){

		// 먹을 수 있는 물고기 찾기
		Queue<int[]> q = new LinkedList<>();
		q.add(shark);

		int[][] visited = new int[n][n];
		visited[shark[0]][shark[1]] = 1;

		while(!q.isEmpty()){

			int[] now = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = now[0] + dx[d];
				int ny = now[1] + dy[d];

				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;

				if (place[nx][ny] > babySize)
					continue;

				if (visited[nx][ny] != 0)
					continue;

				visited[nx][ny] = visited[now[0]][now[1]] + 1;

				if (place[nx][ny] != 0 && place[nx][ny] < babySize){
					fishList.add(new Fish(nx,ny, visited[nx][ny]));
				}

				q.add(new int[] {nx, ny});

			}
		}

	}

}

class Fish implements Comparable<Fish> {
	int x;
	int y;
	int distance;

	public Fish(int x, int y, int distance){
		this.x = x;
		this.y = y;
		this.distance = distance;
	}

	@Override
	public int compareTo(Fish o1){
		if (o1.distance == this.distance){
			if (o1.x == this.x){
				return this.y - o1.y;
			}
			return this.x - o1.x;
		}
		
		return this.distance - o1.distance;


	}
}
