package coding_study.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_9184 {
	static int[][][] dp;
	public static void main(String[] args) throws Exception {

		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		dp = new int[51][51][51];

		while (true){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == -1 && b == -1 && c == -1 )
				break;

			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(recurW(a, b, c)).append("\n");
		}

		System.out.println(sb);
	}
	private static int recurW( int a , int b , int c ){

		if ( a <= 0 || b <= 0 || c <= 0 ) {
			return 1;
		}

		if ( dp[a][b][c] != 0 )
			return dp[a][b][c];

		if( a > 20 || b > 20 || c > 20 ){
			dp[a][b][c] = recurW(20,20,20);
			return dp[a][b][c];
		}

		if ( a < b && b < c ){
			dp[a][b][c] = recurW(a,b,c-1) + recurW(a,b-1,c-1)- recurW(a,b-1,c);
			return dp[a][b][c];
		}

		dp[a][b][c] =  recurW(a-1, b, c) + recurW(a-1, b-1, c) + recurW(a-1, b, c-1 ) - recurW(a-1, b-1, c-1 );
		return dp[a][b][c];
	}

}
