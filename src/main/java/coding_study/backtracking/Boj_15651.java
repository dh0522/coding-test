package coding_study.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15651 {
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new int[m];

		backTracking(0, n, m, 0);
		System.out.println(sb);
	}
	private static void backTracking(int now, int n, int m, int depth){
		if (depth == m){
			for (int i: arr)
				sb.append(i).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= n ;i ++ ){
			arr[depth] = i;
			backTracking(i, n, m, depth+1);
		}
	}
}
