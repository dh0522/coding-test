package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_21610 {
	static int[] dx = {0,-1,-1,-1,0,1,1,1};
	static int[] dy = {-1,-1,0,1,1,1,0,-1};
	static int[][] water;
	static int n,m;
	static boolean[][] cloud;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		water = new int[n][n];
		cloud = new boolean[n][n];

		for( int i =0; i <n ;i++ ){
			st = new StringTokenizer(br.readLine());
			for( int j= 0; j <n ;j++ ){
				water[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] dir = new int[m];
		int[] move = new int[m];

		for( int i = 0; i < m; i++ ){
			st = new StringTokenizer(br.readLine());
			dir[i] = Integer.parseInt(st.nextToken()) -1 ;
			move[i] = Integer.parseInt(st.nextToken());
		}


		// 1. 비바라기
		for( int i = n-2; i < n ; i++ ){
			cloud[i][0] = true;
			cloud[i][1] = true;
		}

		// 2. 구름에 m번 명령 이동
		for( int i = 0; i < m ; i++ ){

			// 이동 후 물+1 함.
			move( dir[i] , move[i] );

		}

		int answer = 0;
		for( int i =0 ; i < n ;i++ ){
			for(int j =0 ; j< n ;j ++ ){
				answer += water[i][j];
			}
		}

		System.out.println(answer);
	}
	private static void move( int d , int num ){

		boolean[][] check = new boolean[n][n];

		for( int i = 0 ; i < n ; i++ ){
			for( int j = 0 ; j < n; j++ ) {

				if( !cloud[i][j] )
					continue;

				int x = i;
				int y = j;

				x = (x + dx[d] * num) % n >= 0 ? (x + dx[d] * num) % n : (x + dx[d] * num) % n + n;
				y = (y + dy[d] * num) % n >= 0 ? (y + dy[d] * num) % n : (y + dy[d] * num) % n + n;

				check[x][y] = true;
				water[x][y]++;
			}

		}

		for( int i =0 ; i < n; i++ ){
			for(int j = 0;j <n ;j ++ ) {

				if( !check[i][j] )
					continue;

				int count = 0;
				for (int dir = 1; dir < 8; dir += 2) {

					int nx = i + dx[dir];
					int ny = j + dy[dir];

					if ( nx < 0 || ny < 0 || nx >= n || ny >= n )
						continue;

					if ( water[nx][ny] > 0 )
						count++;
				}

				water[i][j] += count;
			}
		}

		for( int i =0 ; i < n; i++ )
			Arrays.fill(cloud[i] , false );


		for( int x = 0 ; x< n ;x ++){
			for( int y=0; y <n ; y ++ ){
				if( water[x][y] >= 2 && !check[x][y] ){
					water[x][y] -= 2;
					cloud[x][y] = true;
				}
			}
		}

	}
}
