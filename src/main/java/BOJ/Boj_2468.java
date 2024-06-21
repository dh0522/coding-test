package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2468 {
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int n;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int max = 0;
		map = new int[n][n];
		visited = new boolean[n][n];

		StringTokenizer st;
		for( int i= 0; i< n; i++ ){
			st = new StringTokenizer(br.readLine());
			for( int j = 0 ; j< n; j ++ ){
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max( max , map[i][j] );
			}
		}

		/**
		 * 장마철에 내리는 비의 양에 따라 일정한 높이 이하의 모든 지점은 물에 잠긴다.
		 * map[i][j] = (i,j) 지역의 높이
		 * 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 계산하기.
		 */

		/**
		 *  1. 아무 지역도 물에 잠기지 않을 수 있다.
		 *  2. int max 를 구해서 1 ~ max 까지 다 해봐야함
		 */
		int answer = 0;

		for( int limit = 0; limit <= max; limit++ ){

			visited = new boolean[n][n];

			int temp = 0;
			for( int i = 0 ; i < n ; i++ ){
				for( int j = 0 ; j < n ;j ++ ){
					if( map[i][j] > limit && !visited[i][j] ){
						// 안 잠겼음
						temp++;
						searchBlock( limit , i, j );

					}
				}
			}
			answer = Math.max(answer , temp );

		}

		System.out.println(answer);

	}
	private static void searchBlock( int limit , int x , int y ) {

		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] || map[nx][ny] <= limit)
				continue;

			visited[nx][ny] = true;
			searchBlock(limit, nx,ny);
		}

	}
}
