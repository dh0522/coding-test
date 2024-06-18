package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16234 {
	static int[][] map;
	static boolean[][] visited;
	static int sum = 0;
	static int n, l, r;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0,  -1};
	static ArrayList<int[]> list ;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}

		}
		int answer = move();
		System.out.println(answer);
	}


	public static int move(){

		int answer = 0;
		while( true ){

			boolean ok = false;
			visited = new boolean[n][n];

			for( int i =0 ; i< n; i ++ ){
				for( int j = 0 ; j <n ;j ++ ){
					if( !visited[i][j] ){
						sum = 0;
						if( open(i,j) ) {
							changePeople();
							ok = true;
						}
					}
				}
			}

			if( !ok )
				return answer;
			answer++;
		}
	}

	public static boolean open( int x ,int y ){

		Queue<int[]> q = new LinkedList<>();
		list = new ArrayList<>();

		q.add( new int[] { x, y } );
		visited[x][y] = true;
		list.add(new int[]{x,y});
		sum += map[x][y];

		while( !q.isEmpty() ){

			int[] now = q.poll();

			x = now[0];
			y = now[1];

			for( int i =0 ;i <4; i++ ){

				int nx = x + dx[i];
				int ny = y + dy[i];

				if( nx <0 || ny <0 || nx >=n || ny >= n )
					continue;

				int diff = Math.abs( map[x][y] - map[nx][ny] );
				if( l <= diff && diff <= r && !visited[nx][ny] ){

					visited[nx][ny] = true;
					q.add(new int[]{nx,ny});
					list.add(new int[]{nx,ny});
					sum += map[nx][ny];

				}

			}

		}

		if( list.size() > 1 )
			return true;
		return false;

	}
	public static void changePeople() {

		int num = sum / list.size();

		for( int i = 0 ;i < list.size(); i++ ){
			int[] now = list.get(i);
			int x = now[0];
			int y = now[1];

			map[x][y] = num;
		}
	}
}










