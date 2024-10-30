package programmers.second;

public class Prg_43105 {
	public static void main(String[] args) {
		Prg_43105 sol = new Prg_43105();

		System.out.println(sol.solution( new int[][] {{7}, {3, 8},{8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}} ) ) ;
	}
	private static int solution( int[][] triangle ){
		int answer = 0;


		int[][] dp = new int[triangle.length][triangle.length];

		dp[0][0] = triangle[0][0];

		for( int i=0; i < triangle.length; i++ ){
			for( int j = 0; j <= i; j++ ){
				if( i == 0 && j == 0 )
					continue;
				if( j == 0 ){
					dp[i][j] = dp[i-1][j] + triangle[i][j];
					continue;
				}

				dp[i][j] = Math.max( dp[i-1][j-1] + triangle[i][j] , dp[i-1][j] + triangle[i][j] );
				answer = Math.max( answer , dp[i][j] );
			}
		}


		return answer;
	}
}
