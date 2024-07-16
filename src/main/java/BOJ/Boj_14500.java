package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14500 {
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] arr;
	static boolean[][] visited;
	static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		visited = new boolean[n][m];

		for( int i = 0 ; i < n ; i++ ){
			st  = new StringTokenizer(br.readLine());
			for( int j =0  ; j < m; j ++ ){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for( int i = 0 ; i < arr.length; i++ ){
			for( int j = 0; j < arr[0].length ; j++ ){
				visited[i][j] = true;
				dfs(  1 , i, j ,arr[i][j]  );
				visited[i][j] = false;

			}
		}

		System.out.println(answer);
	}

	private static void dfs( int count , int x, int y ,int sum ){

		if( count == 4 ){
			answer = Math.max( answer , sum );
			return;
		}

		for( int i = 0; i< 4; i++ ){
			int nx = x + dx[i];
			int ny = y + dy[i];

			if( nx < 0 || ny < 0 || nx >= arr.length || ny >= arr[0].length )
				continue;

			if( visited[nx][ny] )
				continue;

			if( count == 2 ){
				visited[nx][ny] = true;
				dfs(count+1, x, y,sum+arr[nx][ny] );
				visited[nx][ny] = false;
			}

			visited[nx][ny] = true;
			dfs( count+1, nx,ny , sum + arr[nx][ny] );
			visited[nx][ny] = false;

		}

	}

}
