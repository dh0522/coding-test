package coding_study.graphandtraversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1260 {
	static int[][] node;
	static boolean[] visited;
	static StringBuilder sbDfs = new StringBuilder();
	public static void main(String[] args) throws Exception {

		int one = 0;
		int two = 0;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		node = new int[n+1][n+1];
		visited = new boolean[n+1];

		for (int i = 0; i < m; i++ ){
			st = new StringTokenizer(br.readLine());

			one = Integer.parseInt(st.nextToken());
			two = Integer.parseInt(st.nextToken());

			node[one][two] = 1;
			node[two][one] = 1;
		}


		dfs(v);
		sb.append( sbDfs ).append("\n");

		sb.append( bfs(v) );

		System.out.println(sb);
	}
	private static String bfs( int now ){

		int next = 0;
		Arrays.fill( visited, false );
		Queue<Integer> q = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();

		q.add(now);
		visited[now] = true;

		while( !q.isEmpty() ){
			next = q.poll();
			sb.append(next).append(" ");

			for( int i = 0; i < node.length; i++ ){
				if( node[next][i] != 1 )
					continue;
				if ( visited[i] )
					continue;

				visited[i] = true;
				q.add(i);
			}
		}

		return sb.toString();
	}
	private static void dfs( int start ){
		visited[start] = true;
		sbDfs.append(start).append(" ");

		for( int i =1; i < node.length; i++ ){
			if( node[start][i] != 1 )
				continue;
			if( visited[i] )
				continue;
			dfs( i );
		}
	}
}
