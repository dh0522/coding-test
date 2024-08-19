package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_17141 {
	static int n,m;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] arr;
	static int answer = Integer.MAX_VALUE;
	static boolean[] visited;
	static List<int[]> virus;
	static int[][] time;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		virus = new ArrayList<>();
		arr = new int[n][n];

		for( int i=0; i< n; i++ ){
			st = new StringTokenizer(br.readLine());
			for( int j=0; j<n; j++ ){
				arr[i][j]  = Integer.parseInt( st.nextToken() );
				if( arr[i][j] == 2 ) {
					virus.add(new int[] {i, j});
				}

			}
		}

		visited = new boolean[virus.size()];
		dfs( 0, 0  );

		if( answer == Integer.MAX_VALUE )
			System.out.println(-1);
		else
			System.out.println(answer);

	}
	private static void dfs( int depth , int idx ){

		if( depth == m ){
			int temp = searchTime();
			answer = Math.min( answer , temp );
			return;
		}

		for( int i= idx ; i < virus.size(); i++ ){
			if( visited[i] )
				continue;

			visited[i] = true;
			dfs( depth+1 , idx +1  );
			visited[i] = false;
		}

	}

	private static int searchTime(){

		time  = new int[n][n];

		Queue<int[]> q= new LinkedList<>();

		for( int i=0; i < virus.size(); i++ ){
			if( visited[i] ){
				int[] now = virus.get(i);
				time[now[0]][now[1]] = 1;
				q.add( now );
			}
		}

		int[] now = new int[2];
		while( !q.isEmpty() ){
			now = q.poll();

			for( int i=0;i <4; i++ ){
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];

				if( nx < 0 || ny < 0 || nx >=n ||ny >= n )
					continue;

				// 벽
				if( arr[nx][ny] == 1 ){
					continue;
				}

				if( time[nx][ny] != 0 )
					continue;

				time[nx][ny] = time[now[0]][now[1]] +1;

				q.add( new int[]{nx,ny} );
			}
		}

		for( int i=0; i< n; i++ ){
			for( int j=0; j< n ;j++ ){
				if( arr[i][j] == 1)
					continue;
				if( time[i][j] == 0 )
					return Integer.MAX_VALUE ;
			}
		}
		return time[now[0]][now[1]]-1 ;
	}

}
