package coding_study.divmulprime;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_2581 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());

		int min = n;
		int sum = 0;
		for ( int i = m; i <= n ; i++ ){
			if ( isPrime(i) ){
				sum += i;
				min = Math.min( min, i );
			}
		}

		if ( min == n && sum == 0 ){
			System.out.println(-1);
			return;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(sum).append("\n");
		sb.append(min);

		System.out.println(sb);

	}
	private static boolean isPrime( int num ){
		if ( num == 1 )
			return false;

		for ( int i = 2 ; i < (int)Math.sqrt(num)+1 ; i++ ){
			if ( num % i == 0)
				return false;
		}

		return true;
	}
}
