package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1987 {
	// 70% 틀렸습니다.
	static int[] dx= {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int r,c;
	static char[][] arr;
	static boolean[][] visited;
	static int answer = 0;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new char[r][c];
		visited = new boolean[r][c];

		for ( int i= 0; i < r; i++ ){
			arr[i] = br.readLine().toCharArray();
		}

		dfs( 0, 0, 0,"" );
		System.out.println(answer);
	}
	private static void dfs( int x , int y , int count , String now ){

		char ch = arr[x][y];
		if ( now.contains( String.valueOf(ch)) ) {
			answer = Math.max( answer , count );
			return;
		}
		now += String.valueOf(ch);

		for (int i=0; i < 4; i++ ){
			int nx = x + dx[i];
			int ny = y + dy[i];

			if ( nx < 0 || ny < 0 || nx >= r || ny >= c )
				continue;

			if ( visited[nx][ny] )
				continue;

			visited[nx][ny] = true;
			dfs( nx, ny, count+1 , now );
			visited[nx][ny] = false;
		}

	}
}
