package coding_study.divmulprime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1978 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;

		for (int i = 0; i < n; i ++ ){
			if( isPrime( Integer.parseInt(st.nextToken()) ))
				answer++;
		}
		System.out.println(answer);
	}
	private static boolean isPrime( int num ){
		if ( num == 1 )
			return false;

		for ( int i = 2; i < (int)Math.sqrt(num)+1 ; i++ )
			if ( num % i == 0 )
				return false;

		return true;

	}
}
