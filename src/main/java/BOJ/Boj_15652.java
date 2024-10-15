package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15652 {
	static int n,m;
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 비 내림차순 = 오름차순

		arr = new int[m];
		dfs( 0 , 0 );

		System.out.println(sb);
	}
	private static void dfs( int depth , int now  ) {
		if (depth == m) {
			for (int i : arr)
				sb.append(i).append(" ");
			sb.append("\n");
			return;
		}

		for ( int i = now ; i < n; i ++ ){
			arr[depth] = i+1;
			dfs( depth+1 , i );
		}
	}
}
