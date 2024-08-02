package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1932 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n][n];
		int answer = -1;
		StringTokenizer st;
		int count = 1;
		for( int i =0; i < n; i++ ){
			st = new StringTokenizer(br.readLine());
			for( int j =0 ; j <= i; j++ ){

				int num = Integer.parseInt(st.nextToken());

				if( i == 0 && j ==0 ){
					dp[i][j] = num;
					answer = Math.max( answer, dp[i][j] );

					continue;
				}
				if( j == 0 ){
					dp[i][j] = dp[i-1][j] + num;
				}else
					dp[i][j] = Math.max( dp[i-1][j] + num, dp[i-1][j-1] +num);
				answer = Math.max( answer, dp[i][j] );

			}
		}

		System.out.println(answer);

	}
}
