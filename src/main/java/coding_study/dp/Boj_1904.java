package coding_study.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_1904 {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n+1];
		// 1 한개 , 00
		if ( n <= 2 ){
			System.out.println(n);
			return;
		}

		dp[1] = 1; // 1
		dp[2] = 2; // 00 11
		// 001 100 111
		// 4 -> 0000 0011 0110 1100 1111
		// 5 -> 00000 00001 00111 11111 00100 10000 10011 11001
		for ( int i = 3; i <= n; i++ ){
			dp[i] = (dp[i-1] + dp[i-2])%15746;
		}

		System.out.println(dp[n]);
	}
}
