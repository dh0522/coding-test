package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_17836 {
	static int n,m,t;
	static int[][] arr;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		arr = new int[n][m];

		for ( int i=0; i < n ; i++ ){
			st= new StringTokenizer(br.readLine());
			for ( int j=0; j< m; j++ )
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

		int answer = bfs();
		System.out.println(answer == 0 ? "Fail" : answer);

	}
	private static int bfs( ){

		Queue<int[]> q = new LinkedList<>();
		int[][] visited = new int[n][m];

		q.add( new int[]{0,0} );
		visited[0][0] = 0;

		boolean check = false;
		int temp = 0;

		while( !q.isEmpty() ){
			int[] now = q.poll();

			if ( now[0] == n-1 && now[1] == m-1 )
				break;

			for ( int d = 0; d < 4; d++ ){
				 int nx = now[0] + dx[d];
				 int ny = now[1] + dy[d];

				 if( nx < 0 || ny < 0 | nx >= n || ny >= m )
					 continue;

				 if ( arr[nx][ny] == 1 ) // 벽
					 continue;

				 if ( visited[nx][ny] != 0 && visited[nx][ny] <= visited[now[0]][now[1]] + 1  )
					 continue;

				 if ( arr[nx][ny] == 2 ){

					 int diff = Math.abs( (n-1)-nx ) + Math.abs( (m-1) - ny);
					 check = true;
					 temp = visited[now[0]][now[1]] +1 + diff;
					 arr[nx][ny] = 0;
				 }

				 visited[nx][ny] = visited[now[0]][now[1]] + 1;
				 q.add( new int[]{ nx, ny } );
			}
		}


		if ( check ) {
			if (visited[n-1][m-1] == 0 )
				visited[n-1][m-1] = temp;
			else
				visited[n - 1][m - 1] = Math.min(visited[n - 1][m - 1], temp);
		}

		if ( visited[n-1][m-1]-1 > t )
			return 0;
		return visited[n-1][m-1];

	}
}
