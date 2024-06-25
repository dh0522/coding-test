package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7562 {
	static int[][] board;
	static int[] dx = {-2,-1,-2,-1,2,1,2,1};
	static int[] dy = {-1,-2,1,2,1,2,-1,-2};
	static int l;
	static  int[][] visited;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 개수
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while( n-- > 0 ){
			l = Integer.parseInt(br.readLine());

			board = new int[l][l];
			visited = new int[l][l];

			int[] start = new int[2];
			int[] goal = new int[2];

			StringTokenizer st = new StringTokenizer(br.readLine());

			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			goal[0] = Integer.parseInt(st.nextToken());
			goal[1] = Integer.parseInt(st.nextToken());

			sb.append(bfs(start, goal) +"\n");

		}
		System.out.println(sb);

	}
	private static int bfs( int[] start , int[] goal ){

		Queue<int[]> q = new LinkedList<>();
		q.add(start);
		int count = 0;

		visited[start[0]][start[1]] = 1;

		while( !q.isEmpty() ){
			start = q.poll();

			int x = start[0];
			int y = start[1];

			if( x ==goal[0] && y == goal[1] )
				break;

			for( int i = 0 ; i< 8; i++ ) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= l || ny >= l)
					continue;

				if (visited[nx][ny] != 0)
					continue;

				q.add(new int[] {nx, ny});
				visited[nx][ny] = visited[x][y] +1 ;

			}
		}
		return visited[goal[0]][goal[1]] -1 ;
	}
}
