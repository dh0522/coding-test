package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_2217 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());


		int[] weight = new int[n];
		for (int i=0; i <n; i++ ){
			weight[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort( weight );

		int answer = Integer.MIN_VALUE;

		for (int i=0;i < n; i++ ){
			answer = Math.max( answer , weight[i]*(n-i) );
		}

		System.out.println(answer);

	}
}

