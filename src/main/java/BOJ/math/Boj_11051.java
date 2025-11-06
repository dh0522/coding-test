package BOJ.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11051 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		if (k == 0){
			System.out.println(1);
			return;
		}

		int[][] dp = new int[n+1][n+1];

		dp[0][0] = 1;
		dp[1][0] = 1;
		dp[1][1] = 1;

		for (int i = 2; i <= n; i++){
			for (int j = 1; j <= n; j++){
				if (j == 0 || i == j){
					dp[i][j] = 1;
				}
				else if(j == 1){
					dp[i][j] = i;
				}else{
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j])%10007;
				}


			}
		}


		System.out.println(dp[n][k]);

	}
}
