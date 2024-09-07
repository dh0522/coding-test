package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_17822 {
	static int n,m;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] map;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		map = new int[n][m];


		for( int i=0 ; i < n; i++ ){
			st = new StringTokenizer( br.readLine());
			for( int j=0; j < m; j++ ){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		for( int i = 0; i < t; i ++ ){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			for( int j=0; j < n; j++ ) {

				if( (j+1)%x != 0 )
					continue;

				if( d == 0 )
					turnClock( j , k );
				else
					turnAnti( j , k );

			}
			findAdjacent();
		}


		int answer = 0;

		for( int i=0; i< n;i ++ ){
			for( int j =0; j < m; j ++ )
				answer += map[i][j];

		}

		System.out.println(answer);

	}
	private static void turnClock( int row, int count ){

		Deque<Integer> dq = new LinkedList<>();
		for( int i = 0; i < m; i++ ){
			dq.add(map[row][i]);
		}

		// 시계 방향 addFirst( pollLast() )
		for( int i =0; i < count ; i++ ){
			dq.addFirst( dq.pollLast() );
		}

		for( int i = 0; i < m; i++ ){
			map[row][i] = dq.pollFirst();
		}

	}
	private static void turnAnti(int row , int count ){

		Deque<Integer> dq = new LinkedList<>();

		for( int i = 0; i < m; i++ ){
			dq.add(map[row][i]);
		}

		// 시계 방향 addFirst( pollLast() )
		for( int i =0; i < count ; i++ ){
			dq.addLast( dq.pollFirst() );
		}

		for( int i = 0; i < m; i++ ){
			map[row][i] = dq.pollFirst();
		}

	}
	private static void findAdjacent(){


		int[][] visited = new int[n][m];

		for( int i=0; i < n; i++ )
			visited[i] = map[i].clone();

		int adjacentNum = 0;

		for( int i=0; i< n;i ++ ){
			for( int j=0; j< m ;j++ ){

				if( map[i][j] == 0 )
					continue;

				int nowNum = map[i][j];

				for( int d= 0; d < 4; d ++ ) {

					int nx = i + dx[d];
					int ny = ( j + dy[d] + m) % m;

					if (nx < 0 || nx >= n )
						continue;

					if ( visited[nx][ny] == 0 )
						continue;

					if ( map[nx][ny] == nowNum ) {
						visited[nx][ny] = 0;
						visited[i][j] = 0;
						adjacentNum++;
					}
				}

			}

		}

		for( int i=0; i < n; i++ )
			map[i]= visited[i].clone();

		if ( adjacentNum == 0 ) {
			double avg = 0;
			int count = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] != 0) {
						avg += map[i][j];
						count++;
					}
				}
			}

			avg /= count;

			for (int i=0; i <n ; i++ ) {
				for (int j = 0; j < m; j++) {
					if ( map[i][j] == 0)
						continue;
					if ( map[i][j] > avg) {
						map[i][j]--;
					} else if (map[i][j] < avg)
						map[i][j]++;
				}
			}
		}

	}
}
