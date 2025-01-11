package coding_study.graphandtraversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj_24479 {
	static int depth = 1;
	static int[] distance;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static void main(String[] args) throws Exception {

		int one = 0;
		int two = 0;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		for( int i =0; i <= n ; i++ )
			graph.add( new ArrayList<>() );

		distance = new int[n + 1];
		visited = new boolean[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			one = Integer.parseInt(st.nextToken());
			two = Integer.parseInt(st.nextToken());

			graph.get(one).add(two);
			graph.get(two).add(one);
		}

		for ( int i =0; i <=n; i ++ )
			Collections.sort( graph.get(i) );


		dfs(r);

		for ( int i = 1; i <= n; i++ )
			sb.append(distance[i]).append("\n");

		System.out.println(sb);

	}
	private static void dfs(int now) {

		distance[now] = depth++;
		visited[now] = true;

		for ( int next: graph.get(now) ){
			if ( visited[next] )
				continue;

			dfs(next);
		}
	}
}


