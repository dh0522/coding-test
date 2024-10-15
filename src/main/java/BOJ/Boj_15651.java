package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15651 {
	static int[] arr;
	static int n,m;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt( st.nextToken() );
		m = Integer.parseInt(st.nextToken());

		arr = new int[m];

		dfs( 0);
		System.out.println(sb);

	}
	private static void dfs( int depth ){
		if( depth == m ){
			for (int i: arr)
				sb.append(i).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++ ){
			arr[depth] = i+1;
			dfs(  depth+1 );
		}
	}
}
