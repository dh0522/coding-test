package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_12865 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 물품의 개수
		int n = Integer.parseInt(st.nextToken());
		// 준서가 버틸 수 있는 무게
		int k = Integer.parseInt(st.nextToken());

		int[][] stuff = new int[n][2];

		for (int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			stuff[i][0] = Integer.parseInt(st.nextToken());
			stuff[i][1] = Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[n+1][k+1];

		for (int i = 1; i <= n; i++){
			for (int j = 1; j <= k; j++ ){
				dp[i][j] = dp[i-1][j];

				int weight = stuff[i-1][0];
				int value = stuff[i-1][1];


				if (weight <= j){
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j - weight] + value);
				}
			}

		}

		System.out.println(dp[n][k]);


	}

}














