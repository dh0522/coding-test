package coding_study.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_27433 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		System.out.println(recur(n));
	}
	private static long recur( int n ){
		if ( n <= 1 )
			return 1;

		return n*recur(n-1);
	}
}
