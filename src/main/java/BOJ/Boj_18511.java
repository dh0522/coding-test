package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_18511 {
	static int n,k;
	static int length;
	static int[] arr;
	static int answer = 0;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[k];
		st = new StringTokenizer(br.readLine());

		for ( int i =0; i < k ; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort( arr );

		search( 0  );
		System.out.println(answer);
	}
	private static void search( int now ){

		if( now > n )
			return;

		if( (n-now) < ( n -answer) ){
			answer = now;
		}

		for ( int i=0; i< k; i++ ){
			search( now*10 + arr[i] );
		}

	}
}
