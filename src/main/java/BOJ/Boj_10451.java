package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10451 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while( t-- > 0 ){

			int n = Integer.parseInt(br.readLine());

			int[] arr = new int[n+1];
			boolean[] visited = new boolean[n+1];

			st = new StringTokenizer(br.readLine());

			for (int i=1; i <=n; i++ ){
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int answer = 0;
			for (int i=1; i<=n ;i++ ){
				if (visited[i])
					continue;

				visited[i] = true;
				int start = arr[i];

				while( start != i ){
					visited[start] = true;
					start = arr[start];
				}
				answer++;

			}

			sb.append(answer+"\n");
		}
		System.out.println(sb);
	}
}
