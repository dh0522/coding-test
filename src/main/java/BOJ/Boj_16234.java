package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_16234 {
	static int ans = 0;
	static int n,l,r;
	static int[][] map;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static boolean[][] visited;
	static ArrayList<int[]> list ;
	static int sum = 0;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		map = new int[n][n];


		for( int i =0 ; i < n ; i++ ){
			st = new StringTokenizer(br.readLine());
			for( int j = 0 ;j < n; j++ ){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		move();
		System.out.println(ans);
	}
	public static void move(){

		while( true ){

			visited = new boolean[n][n];
			boolean ok = false;

			for( int i = 0 ; i< n; i++ ){
				for( int j = 0; j< n; j++ ){

					if( !visited[i][j] ){
						sum = 0;
						if( possible(i,j) ) {
							ok = true;
							letsmove();
						}
					}
				}
			}
			if( !ok )
				break;
			ans++;

		}
	}
	public static boolean possible(int x , int y ){

		Queue<int[]> q = new LinkedList<>();
		list = new ArrayList<>();

		visited[x][y] = true;

		sum = map[x][y];
		q.add( new int[]{x,y});
		list.add( new int[]{x,y});

		while( !q.isEmpty() ){

			int[] now = q.poll();

			x = now[0];
			y = now[1];

			for( int i =0 ; i< 4; i++ ){

				int nx = x + dx[i];
				int ny = y + dy[i];

				if( nx < 0 || ny < 0 || nx >=n || ny >=n )
					continue;

				if ( visited[nx][ny] )
					continue;

				int diff = Math.abs( map[nx][ny] - map[x][y] );

				if( l <= diff && diff <= r ){

					sum += map[nx][ny];
					visited[nx][ny] = true;
					q.add( new int[]{nx,ny});
					list.add( new int[]{nx,ny});

				}

			}

		}

		if( list.size() > 1  )
			return true;
		return false;
	}
	public static void letsmove(){

		int newNum = sum / list.size();

		for( int i =0; i< list.size(); i++ ){

			int x = list.get(i)[0];
			int y = list.get(i)[1];

			map[x][y] = newNum;

		}
	}
}
