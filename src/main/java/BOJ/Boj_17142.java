package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_17142 {
	static int[][] arr;
	static int n;
	static List<int[]> list = new ArrayList<>();
	static boolean[] visited;
	static int answer = Integer.MAX_VALUE;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int zero =0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new int[n][n];

		for( int i =0; i <n ; i ++ ){
			st = new StringTokenizer(br.readLine());
			for( int j=0; j < n ;j ++ ){
				arr[i][j] = Integer.parseInt( st.nextToken() );
				if( arr[i][j] == 2 ){
					list.add( new int[]{i,j} );
				}else if( arr[i][j] == 0 )
					zero++;
			}
		}

		visited = new boolean[list.size()];

		if( zero == 0 ){
			System.out.println(0);
			return;
		}

		dfs( 0 , 0 , m );

		System.out.println( answer == Integer.MAX_VALUE ? -1 : answer );

	}
	private static void dfs( int depth , int idx , int m ){
		if( depth == m ){
			searchTime();
			return;
		}

		for( int i = idx; i < list.size(); i++ ){
			if( visited[i] )
				continue;

			visited[i] = true;
			dfs( depth+1, i+1, m );
			visited[i] = false;
		}

	}
	private static void searchTime(){

		int[][] time = new int[n][n];
		boolean[][] vis = new boolean[n][n];

		Queue<int[]> q = new LinkedList<>();

		for( int i=0; i < list.size(); i++ ){
			if( visited[i] ){
				int[] now = list.get(i);
				time[now[0]][now[1]] = 1;
				vis[now[0]][now[1]] = true;
				q.add(now);
			}
		}


		int max = 0;
		int tmpZero =0;

		while( !q.isEmpty() ){

			int[] now = q.poll();

			for( int i=0; i <4; i++ ){
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];

				if( nx < 0 || ny < 0 || nx >= n || ny >= n )
					continue;

				if( vis[nx][ny] || arr[nx][ny] == 1)
					continue;

				vis[nx][ny] = true;
				time[nx][ny] = time[now[0]][now[1]] + 1;
				q.add( new int[]{nx,ny} );

				if( arr[nx][ny] == 0 ) {
					tmpZero++;
					max = Math.max( max , time[nx][ny] );
				}
			}
		}


		if( zero == tmpZero ) {
			answer = Math.min(max - 1, answer);
		}

	}
}
