package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1149 {
	public static void main(String[] args) throws Exception {
		/**
		 *   N 개의 집
		 *   거리는 선분으로 나타낸다.
		 *   집은 빨 초 파 중 하나로 칠해야 한다.
		 *   1 > 1번 집 색 != 2번 집 색
		 *   2 > N번 집 색 != N-1번 집 색
		 *
		 *   즉 앞 뒤로 있는 집들의 색이 서로 달라야 한다.
		 *   비용의 최소값 구하기
		 *
		 */
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		int[][] dp = new int[n+1][3];
		for( int i =1 ; i <= n ;i ++ ){
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt( st.nextToken() );
			int g = Integer.parseInt( st.nextToken()) ;
			int b = Integer.parseInt( st.nextToken() );

			dp[i][0] = Math.min( dp[i-1][1] , dp[i-1][2] )+ r;
			dp[i][1] = Math.min( dp[i-1][0] , dp[i-1][2] )+ g;
			dp[i][2] = Math.min( dp[i-1][0] , dp[i-1][1] )+ b;
		}

		System.out.println( Math.min( Math.min(dp[n][0], dp[n][1]), dp[n][2]) ) ;

	}
}
