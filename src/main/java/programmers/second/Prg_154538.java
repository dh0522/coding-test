package programmers.second;

import java.util.Arrays;

public class Prg_154538 {
	public static void main(String[] args) {
		Prg_154538 sol = new Prg_154538();
		System.out.println(sol.solution( 10, 40, 5 ));
		System.out.println(sol.solution( 10, 40, 30 ));
		System.out.println(sol.solution( 2, 5, 4 ));
	}
	private static int solution( int x, int y, int n ){

		int[] dp = new int[y+1];
		Arrays.fill( dp, Integer.MAX_VALUE );
		dp[x] = 0;

		for( int i = x+1; i <= y; i++ ){

			if( (i%2) == 0 && dp[i/2] != Integer.MAX_VALUE ){
				dp[i] = Math.min( dp[i/2] + 1, dp[i] );
			}
			if( (i%3) == 0 && dp[i/3] != Integer.MAX_VALUE ){
				dp[i] = Math.min( dp[i/3] +1, dp[i] );
			}
			if( 0 <= (i-n) && dp[i-n] != Integer.MAX_VALUE ){
				dp[i] = Math.min(dp[i-n] + 1, dp[i] );
			}
		}


		return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
	}
}
