package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_2847 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());


		int[] arr = new int[n];
		for (int i=0; i< n; i++ ){
			arr[i] = Integer.parseInt(br.readLine());
		}

		int answer = 0;


		for (int i=n-2; i>=0; i-- ){
			if( arr[i+1] > arr[i] )
				continue;
			int diff = Math.abs( arr[i+1] - arr[i] );
			arr[i] = arr[i+1] -1 ;
			answer += diff + 1 ;

		}

		System.out.println(answer);

	}
}
