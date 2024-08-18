package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_9466 {
	static int[] student;
	static boolean[] recur;
	static boolean[] visited;
	static int answer;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while( t-- > 0 ){

			int n = Integer.parseInt(br.readLine());
			answer = 0;

			student = new int[n+1];

			recur = new boolean[n+1];
			visited = new boolean[n+1];

			st = new StringTokenizer(br.readLine());

			for( int i=1; i <= n; i++ ){
				student[i] = Integer.parseInt(st.nextToken());
				if( i == student[i] ){
					recur[i] = true;
					answer++;
				}
			}

			for( int i=1; i<= n; i++ ){
				if( recur[i] )
					continue;
				dfs( i );
			}

			sb.append(n-answer+"\n");

		}
		System.out.println(sb);

	}
	private static void dfs( int now ){
		/**
		 *   recur = 이미 i->i를 선택했을 경우
				or 이미 지나갔음
 		 */
		if( recur[now] )
			return;

		if( visited[now] ){
			answer++;
			recur[now] = true;
		}

		visited[now] = true;
		dfs( student[now] );

		recur[now] = true;
		visited[now] = false;

	}
}
