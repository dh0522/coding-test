package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_2012 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader( new InputStreamReader(System.in ));

		int n = Integer.parseInt(br.readLine());
		int[] people = new int[n+1];

		for (int i=1; i<=n; i++ ){
			people[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort( people );

		long answer = 0;
		for (int i=1; i <=n; i ++ ){
			answer += Math.abs( people[i]-i );
		}

		System.out.println(answer);
	}
}
