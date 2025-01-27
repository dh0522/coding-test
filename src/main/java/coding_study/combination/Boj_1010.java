package coding_study.combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1010 {
	static int[][] dp = new int[30][30];
	public static void main(String[] args) throws Exception {

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while(t-- >0){
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());


			sb.append( combi(m, n)).append("\n");

		}
		System.out.println(sb);
	}
	private static int combi(int n, int r){
		// nCr = n-1C(r) + (n-1)C(r-1)
		if( dp[n][r] != 0 )
			return dp[n][r];

		if ( n == r || r == 0 )
			return dp[n][r] = 1;

		return dp[n][r] = combi(n-1,r) + combi(n-1,r-1);

	}
}
