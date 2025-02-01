package coding_study.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_10870 {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		if (n == 0){
			System.out.println(0);
			return;
		}
		System.out.println( recur(n) );

	}
	private static int recur( int n ){
		if( n <= 2 )
			return 1;

		return recur(n-2) + recur(n - 1);
	}
}
