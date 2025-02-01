package coding_study.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15649 {
	static StringBuilder answer = new StringBuilder();
	static boolean[] visited;
	static int[] arr;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new int[m];
		visited = new boolean[n+1];
		// 1 ~ n 까지의 자연수 중에서 중복 없이 M 개를 고른 수열
		// 위의 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램


		backTracking(n, m , 0);

		System.out.println(answer);
	}
	private static void backTracking(int n, int m, int depth){
		if(depth == m){
			for (int i = 0; i < m; i++ ){
				answer.append(arr[i]).append(" ");
			}
			answer.append("\n");
			return;
		}

		for (int i = 1; i <= n; i++ ){
			if (visited[i])
				continue;

			visited[i] = true;
			arr[depth] = i;
			backTracking( n, m, depth+1 );
			visited[i] = false;
		}
	}
}
