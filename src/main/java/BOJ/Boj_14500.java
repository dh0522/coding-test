package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14500 {
	static int[][] arr;
	static int answer = Integer.MIN_VALUE;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][] visited;
	static int n,m;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		visited = new boolean[n][m];

		for( int i =0; i < n; i++ ){
			st = new StringTokenizer(br.readLine());
			for( int j=0; j < m; j++ )
				arr[i][j] = Integer.parseInt(st.nextToken());

		}
		for( int i=0; i < n; i++ ){
			for( int j=0; j < m; j ++ ) {
				visited[i][j] = true;
				searchMax(i, j, 1, arr[i][j]);
				visited[i][j] = false;
			}

		}
		System.out.println(answer);
	}
	private static void searchMax( int x , int y , int depth , int sum ){

		if( depth == 4 ){
			answer = Math.max( answer , sum );
			return;
		}

		for( int i =0; i < 4; i++ ){
			int nx = x + dx[i];
			int ny = y + dy[i];

			if( nx < 0 || ny < 0 || nx >= n || ny >= m )
				continue;

			if( visited[nx][ny] )
				continue;

			if( depth == 2 ){

				visited[nx][ny] = true;
				searchMax(x,y,depth+1,sum+arr[nx][ny]);
				visited[nx][ny] = false;

			}

			visited[nx][ny] = true;
			searchMax(nx,ny,depth+1,sum+arr[nx][ny]);
			visited[nx][ny] = false;
		}

	}
}
