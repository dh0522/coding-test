package coding_study.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1912 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];

		for ( int i = 0 ; i< n; i ++ ){
			arr[ i ] = Integer.parseInt(st.nextToken() );
		}

		if ( n == 1 ){
			System.out.println(arr[0]);
			return;
		}

		int[] dp = new int[n];
		dp[0] = arr[0];
		dp[1] = arr[1];

		int max = dp[0];
		for ( int i = 1 ; i < n; i++ ){
			dp[i] = Math.max( dp[i-1] + arr[i] , arr[i] );
			max = Math.max( max, dp[i] );
		}


		System.out.println(max);

	}
}
