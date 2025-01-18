package coding_study.graphandtraversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_24480 {
	static List<List<Integer>> list = new ArrayList<>();
	static int[] visited;
	static int depth = 1;
	public static void main(String[] args) throws Exception {

		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		visited = new int[n+1];



		for (int i = 0; i <= n; i++ ){
			list.add( new ArrayList<>() );
		}

		for (int i =0; i < m; i++ ){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list.get(a).add(b);
			list.get(b).add(a);
		}

		for (int i=1; i <=n; i++ )
			Collections.sort( list.get(i), Collections.reverseOrder() );

		dfs( r );

		for ( int i = 1; i <= n; i++ ){
			sb.append(visited[i]).append("\n");
		}

		System.out.println(sb);
	}
	private static void dfs( int now ){

		visited[now] = depth++;

		for( int next : list.get(now) ){
			if ( visited[next] != 0 )
				continue;
			dfs(next);
		}

	}
}
