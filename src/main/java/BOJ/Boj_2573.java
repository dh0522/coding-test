package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2573 {
	static int[][] arr;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][] visited;
	static boolean allZero = false;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];

		for( int i = 0 ; i< n ; i++ ){
			st = new StringTokenizer(br.readLine());
			for( int j = 0 ; j < m ; j++ ){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int year = 0;

		while( isPossible( n ,m ) ){

			bfs( n ,m );
			year++;
		}
		if( allZero )
			System.out.println(0);
		else System.out.println( year );
	}
	private static void bfs( int n , int m ){

		int[][] tmp = new int[n][m];
		for( int i = 0 ; i < n ; i++ )
			tmp[i] = arr[i].clone();

		for( int i = 1 ; i < n-1 ; i++ ){
			for( int j = 1 ; j < m-1 ; j++ ){

				if( arr[i][j] != 0 ){

					int zero = 0;

					for( int d= 0; d < 4; d++ ){
						int nx = i + dx[d];
						int ny = j + dy[d];

						if( nx < 0 || ny < 0 || nx >= n || ny >= m )
							continue;

						if( arr[nx][ny] == 0 )
							zero++;

					}

					if( arr[i][j] - zero > 0 ){
						tmp[i][j] -= zero;
					}else tmp[i][j] = 0;

				}

			}
		}


		for( int i = 0 ; i < n; i++ )
			arr[i] = tmp[i].clone();

	}

	private static boolean isPossible(  int n, int m ) {

		int part = 0;
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] != 0 && !visited[i][j] ) {
					part++;
					searchPart(i, j);
				}

			}
		}
		if( part == 1 )
			return true;

		if( part == 0 ) {
			allZero = true;
		}

		return false;
	}
	private static void searchPart( int x , int y ){
		Queue<int[]> q = new LinkedList<>();
		visited[x][y] = true;

		q.add(new int[]{x,y} );

		while(!q.isEmpty()){
			int[] now = q.poll();
			x = now[0];
			y = now[1];

			for( int i = 0 ; i< 4; i ++ ){
				int nx = x + dx[i];
				int ny = y + dy[i];

				if( nx <0 || ny < 0 || nx >= arr.length || ny >= arr[0].length )
					continue;

				if( visited[nx][ny] || arr[nx][ny] == 0 )
					continue;

				visited[nx][ny] = true;
				q.add(new int[]{nx,ny});

			}
		}

	}
}
