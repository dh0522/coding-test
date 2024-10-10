package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1600 {
	static int[] horseX = {-2,-2,-1,-1,1,1,2,2};
	static int[] horseY = {-1,1,-2,2,-2,2,-1,1};
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] arr;
	static int k, w, h;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		arr = new int[h][w];
		for ( int i=0; i < h; i++ ){
			st = new StringTokenizer(br.readLine());
			for (int j=0; j < w; j++ ){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}



		System.out.println( bfs() );

	}
	private static int bfs( ){

		Queue<Point> q = new LinkedList<>();
		int[][][] visited = new int[h][w][k+1];

		visited[0][0][0] = 1;
		q.add( new Point(0,0,0) );

		while( !q.isEmpty() ){
			Point now = q.poll();

			if( now.x == h-1 && now.y == w-1 )
				return visited[now.x][now.y][now.k]-1;

			for (int i =0; i < 4; i++ ){
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if( nx < 0 || ny < 0 || nx >= h || ny >=w )
					continue;

				if( arr[nx][ny] == 1 )
					continue;
				if ( visited[nx][ny][now.k] != 0 )
					continue;

				visited[nx][ny][now.k] = visited[now.x][now.y][now.k] + 1;
				q.add( new Point(nx,ny,now.k) );

			}

			if ( now.k == k )
				continue;

			for (int i=0; i < 8; i++ ){

				int nx = now.x + horseX[i];
				int ny = now.y + horseY[i];

				if( nx < 0 || ny < 0 || nx >= h || ny >=w )
					continue;
				if( arr[nx][ny] == 1 )
					continue;
				if ( visited[nx][ny][now.k+1] != 0 )
					continue;

				visited[nx][ny][now.k+1] = visited[now.x][now.y][now.k] + 1;
				q.add( new Point(nx,ny,now.k+1) );

			}

		}

		return -1;

	}
	public static class Point{
		int x,y,k;
		Point( int x, int y , int k ){
			this.x = x;
			this.y = y;
			this.k = k;
		}
	}
}
