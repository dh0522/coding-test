package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11055 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n+1];

		for( int i=1; i <= n; i ++ ){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[n+1];
		dp[0] = arr[0];
		dp[1] = arr[1];

		int max = 0;
		for( int i = 1; i <= n ;i ++ ){
			dp[i] = arr[i];
			for( int j =1  ; j < i ;j ++ ){
				if( arr[i] > arr[j] ){
					dp[i] = Math.max( dp[i] , dp[j] + arr[i] );
				}
			}
			max = Math.max( dp[i] , max );
		}

		System.out.println( max );
	}
}
