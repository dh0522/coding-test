package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_2579 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));

		// 계단 개수
		int n = Integer.parseInt(br.readLine());

		int[] stairs = new int[n+1];
		for (int i = 1; i <= n; i++){
			int score = Integer.parseInt(br.readLine());

			stairs[i] = score;
		}

		// 계단 아래 시작점부터 계단 꼭대기에 위치한 도착점까지 가는 게임

		// 계단을 올리는 데 다음과 같은 규칙
		// 1. 계단은 한칸 혹은 두칸 올라갈 수 있다. (세칸 이상 안돼)
		// 2. 연속된 세 개의 계단을 모두 밟아서는 안된다. -> 시작점은 계단에 포함되지 않는다.
		// 3. 마지막 도착 계단은 반드시 밟아야 한다.

		int[] dp = new int[n+1];
		dp[1] = stairs[1];
		if(n >= 2)
			dp[2] = dp[1] + stairs[2];
		if(n >= 3)
			dp[3] = Math.max(stairs[1], stairs[2]) + stairs[3];
		for (int i = 4; i <= n; i++){
			dp[i] =  Math.max(dp[i-3] + stairs[i-1], dp[i-2]) + stairs[i];
		}


		System.out.println(dp[n]);



	}
}
