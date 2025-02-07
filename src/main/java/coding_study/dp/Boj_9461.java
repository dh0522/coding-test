package coding_study.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_9461 {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		long[] dp = new long[101];

		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		for (int i = 6; i <= 100; i++ ){
			dp[i] = dp[i-1] + dp[i-5];
		}

		while(t-- >0){
			int num = Integer.parseInt(br.readLine());

			sb.append(dp[num]).append("\n");
		}

		System.out.println(sb);
	}
}
