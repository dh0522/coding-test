package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15650 {
	static int m,n;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());


		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n];
		visited = new boolean[n];

		dfs( 0 , 0 );
		System.out.println(sb);

	}
	private static void dfs( int depth , int now ){
		if( depth == m ){
			for ( int i=0; i < m ; i++ ){
				sb.append( arr[i]+" ");
			}
			sb.append("\n");
			return;
		}

		for ( int i = now; i < n; i++ ){
			if ( visited[i] )
				continue;

			visited[i] = true;
			arr[depth] = i+1;
			dfs( depth+1 , i );
			visited[i] = false;
		}

	}
}
