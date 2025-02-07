package coding_study.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_24416 {
	static int count = 0;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		recur(n);
		sb.append( count ).append(" ");
		sb.append( dp(n) );

		System.out.println(sb);


	}
	private static int dp( int n ){
		int[] dp = new int[n+1];
		int idx = 0;

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;

		for (int i =3; i <=n; i++ ){
			dp[i] = dp[i-1] + dp[i-2];
			idx++;
		}

		return idx;
	}

	private static int recur( int n ){

		if ( n == 1 || n == 2 ) {
			count++;
			return 1;
		}
		return recur(n-1) + recur(n-2);
	}
}
