package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1987 {
	static int[] dx= {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int r,c;
	static boolean[] visited = new boolean[26];
	static int[][] arr;
	static int answer = 0;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new int[r][c];

		for( int i = 0; i < r; i++ ){
			String temp = br.readLine();
			for ( int j=0; j < c; j++ ){
				arr[i][j] = temp.charAt(j)-'A';
			}
		}

		if ( r == 1 && c== 1 ){
			System.out.println(1);
			return;
		}
		dfs( 0, 0, 0 );
		System.out.println(answer);

	}
	private static void dfs( int x, int y , int count ){

		if( visited[ arr[x][y] ]  ){
			answer = Math.max( answer , count );
			return;
		}


		visited[arr[x][y]] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= r || ny >= c)
				continue;
			dfs(nx, ny, count + 1);
		}
		visited[arr[x][y]] = false;

	}
}
