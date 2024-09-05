package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_5585 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		/**
		 *
		 * 1000엔 지폐를 냈을 때
		 * 받을 잔돈에 포함된 잔돈의 개수 구하여라
		 *  500, 100, 50, 10 ,5 1
		 */

		int remain = 1000-n;
		int count = 0;

		count = remain/500 + remain%500/100 + remain%500%100/50 + remain%500%100%50/10 + remain%500%100%50%10/5 + remain%500%100%50%10%5 ;
		System.out.println(count);

	}
}
