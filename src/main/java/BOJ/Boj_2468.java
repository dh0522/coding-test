package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2468 {
	static int n , answer = 0;
	static int[][] map;
	static int max = -1 ;
	static boolean[][] visited;
	static int[] dx = { 1, 0 ,-1, 0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		map = new int[n][n];

		StringTokenizer st;
		for( int i=0 ;i <n ;i++ ){
			st = new StringTokenizer(br.readLine());
			for( int j= 0 ; j <n ; j++ ){
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max( max , map[i][j] );
			}
		}

		for( int i = 0; i<= max; i++ ){
			visited = new boolean[n][n];
			int count = 0;

			for( int x=0; x < n ; x++ ){
				for( int y = 0; y < n; y++ ){

					if( !visited[x][y] && map[x][y] > i ) {
						bfs(i, x, y);
						// 물에 잠기지 않는 안전한 영역
						count++;
					}

				}
			}
			answer = Math.max(count , answer);
		}
		System.out.println(answer);
	}
	private static void bfs( int limit ,int x , int y ){

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{x,y});

		visited[x][y] = true;

		while( !q.isEmpty() ){

			int[] now = q.poll();

			x = now[0];
			y = now[1];

			for( int i =0 ;i < 4; i++ ){
				int nx = x + dx[i];
				int ny = y + dy[i];

				if( nx < 0 || ny < 0 || nx >=n || ny >= n )
					continue;

				if( visited[nx][ny] )
					continue;

				if( map[nx][ny] > limit ){
					visited[nx][ny] = true;
					q.add(new int[]{nx,ny} );
				}
			}

		}
	}
}
