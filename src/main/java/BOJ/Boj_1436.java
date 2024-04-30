package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1436 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt( br.readLine() );

		// 666이 들어가는 n번째로 작은 수를 출력하기

		int[] dp = new int[n+1];
		int num = 0;

		for( int i = 666; i < Integer.MAX_VALUE; i++ ){

			String temp = String.valueOf(i);
			if( temp.contains("666" ) ){
				dp[num] = i;
				num++;
			}
			if( num == n )
				break;
		}
		System.out.println(dp[n-1]);

	}
}
