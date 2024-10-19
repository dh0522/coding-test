package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_22858 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt( st.nextToken());
		int k = Integer.parseInt( st.nextToken());

		int[] p = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for ( int i= 1; i <= n ; i++ ){
			p[i] = Integer.parseInt(st.nextToken());
		}

		int[] d = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for ( int i=1; i <= n; i ++ ){
			d[i] = Integer.parseInt(st.nextToken());
		}

		while( k-- > 0 ){

			int[] newArr = new int[n+1];
			for ( int i=1; i<= n; i++ ){
				newArr[ d[i] ] = p[ i ];
			}
			p = newArr;
		}

		for ( int i=1; i <=n ;i++ )
			System.out.print( p[i]+" ");

	}
}
