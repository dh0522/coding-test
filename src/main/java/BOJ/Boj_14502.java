package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_14502 {
	static int n,m;
	static int[][] arr;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int answer = Integer.MIN_VALUE;
	static int zero = 0;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];

		// 		0: 빈칸	 1: 벽 	 2: 바이러스
		for( int i= 0 ; i< n; i++ ){
			st = new StringTokenizer(br.readLine());
			for( int j= 0; j <m ; j++ ){
				arr[i][j] = Integer.parseInt(st.nextToken());
				if( arr[i][j] == 0 )
					zero++;
			}
		}

		/**
		 *  	1. 벽 3개 랜덤 세우기
		 *  	2. 바이러스 뿌리기
		 *  	3. 안전 영역 개수 구하기
		 */

		dfs( 0 );

		System.out.println(answer);

	}
	private static void dfs( int count  ){
		if( count == 3 ){
			virus( arr );
			return;
		}

		for(int i =0; i <n ;i++ ){
			for( int j =0 ;j < m; j++ ){
				if( arr[i][j] == 0 ) {
					arr[i][j] = 1;
					dfs( count+1 );
					arr[i][j] = 0;
				}
			}
		}


	}

	private static void virus( int[][] arr ){

		boolean[][] visited = new boolean[n][m];
		int virusNum = 0;
		Queue<int[]> q = new LinkedList<>();

		for( int i = 0 ; i < n ; i++ ){
			for( int j = 0; j < m ;j ++ ){
				if( arr[i][j] == 2  ){
					q.add(new int[]{i,j});
				}
			}
		}

		int[][] tmpArr = new int[n][m];
		for( int i= 0 ; i< n; i++ )
			tmpArr[i] = arr[i].clone();


		while( !q.isEmpty() ){

			int[] now = q.poll();
			int x = now[0];
			int y = now[1];

			for( int i=0 ; i< 4; i++ ){

				int nx = x + dx[i];
				int ny = y + dy[i];

				if( nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;

				if( visited[nx][ny] || tmpArr[nx][ny] == 1 || tmpArr[nx][ny] == 2 )
					continue;

				virusNum++;
				visited[nx][ny] = true;
				tmpArr[nx][ny] = 2;
				q.add(new int[]{nx,ny});

			}

		}

		answer = Math.max ( answer , zero - 3 - virusNum );

	}
}
