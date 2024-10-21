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

		search( "" );
		System.out.println(answer);
	}
	private static void search( String now  ){

		if( 0 < now.length() && now.length() <=  length ){

			if( Integer.parseInt( now ) > n )
				return;

			int tmp = Integer.parseInt( now );
			if( Math.abs( tmp - n ) < Math.abs( n - answer ) ){
				answer = tmp;
			}

			if ( now.length() == length)
				return;
		}

		String temp = now;
		for (int i=0; i < k; i ++ ){
			now = temp ;
			search( now + String.valueOf( arr[i] ) );
		}

	}
}
