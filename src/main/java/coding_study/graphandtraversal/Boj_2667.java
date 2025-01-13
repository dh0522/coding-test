package coding_study.graphandtraversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2667 {
	static char[][] chArr;
	static boolean[][] visited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		StringBuilder answer = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		chArr = new char[n][n];
		visited = new boolean[n][n];

		List<Integer> list = new ArrayList<>();

		for (int i=0; i < n; i++){
			chArr[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < n; i++ ){
			for( int j = 0; j < n; j++ ){
				if( chArr[i][j] == '0' )
					continue;

				if( visited[i][j] )
					continue;

				list.add( bfs(i, j) );
			}
		}

		Collections.sort( list );
		answer.append(list.size()).append("\n");
		for ( int i : list )
			answer.append(i).append("\n");
		System.out.println(answer);
	}
	private static int bfs(int x, int y){

		int nx = x;
		int ny = y;
		int ans = 1;
		int[] next = {0,0};


		Queue<int[]> q = new ArrayDeque<>();
		q.add( new int[]{x,y} );
		visited[x][y] = true;

		while(!q.isEmpty()){
			next = q.poll();

			for (int d =0; d < 4; d++ ){
				nx = next[0] + dx[d];
				ny = next[1] + dy[d];

				if ( nx < 0 || ny < 0 || nx >= visited.length || ny >= visited.length )
					continue;

				if( visited[nx][ny] )
					continue;
				if (chArr[nx][ny] == '0')
					continue;

				visited[nx][ny] = true;
				ans++;
				q.add( new int[]{nx,ny} );
			}

		}

		return ans;
	}
}
