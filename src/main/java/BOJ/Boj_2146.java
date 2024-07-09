package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2146 {
	static boolean[][] visit;
	static int n;
	static int[][] map;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		StringTokenizer st;
		for( int i = 0; i < n; i++ ){
			st = new StringTokenizer(br.readLine());
			for( int j = 0 ;j < n ;j ++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visit = new boolean[n][n];
		int num = 2;
		for(int i =0; i < n; i++ ){
			for( int j = 0; j< n; j++ ){
				if( !visit[i][j] && map[i][j] == 1 ){
					changeIsland( i, j ,num++ );
				}
			}
		}

		for( int i = 0 ; i < n ; i++ ){
			for( int j = 0; j < n ; j++ ){
				if( map[i][j] == 0 )
					continue;
				shortPath(i,j,map[i][j]);
			}
		}

		System.out.println(answer);
	}
	private static void shortPath( int x, int y , int nowIsland ){


		Queue<int[]> q = new LinkedList<>();
		q.add( new int[]{ x,y });
		int[][] visited = new int[n][n];
		visited[x][y] = 1;

		while( !q.isEmpty() ){
			int[] now = q.poll();
			x = now[0];
			y = now[1];

			if( visited[x][y] > answer )
				continue;

			for( int i = 0 ; i< 4; i++ ) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;
				if (visited[nx][ny] != 0)
					continue;

				if( map[nx][ny] != 0 && map[nx][ny] != nowIsland ){
					answer = Math.min( answer , visited[x][y]-1 );
					return;
				}

				q.add(new int[] {nx, ny});
				visited[nx][ny] = visited[x][y] + 1;
			}
		}
	}
	private static void changeIsland( int x, int y , int num ){

		visit[x][y] = true;
		map[x][y] = num;

		for( int i = 0 ; i < 4; i++ ){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if( nx < 0 || ny < 0 || nx >= n || ny >= n )
				continue;
			if( visit[nx][ny] || map[nx][ny] == 0 )
				continue;
			changeIsland(nx,ny,num);
		}
	}
}
