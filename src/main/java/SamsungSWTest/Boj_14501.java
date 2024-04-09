package SamsungSWTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_14501 {
	private static int[][] consult;
	private static int answer, temp;
	private static boolean[] visited;
	public static void main(String[] args) throws IOException  {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		consult = new int[n][2];
		visited = new boolean[n];

		StringTokenizer st;
		for( int i = 0 ; i< n; i++ ){
			st = new StringTokenizer(br.readLine());

			consult[i][0] = Integer.parseInt(st.nextToken());
			consult[i][1] = Integer.parseInt(st.nextToken());

		}

		search( n  , 0 , 0 );

		System.out.println(answer);
	}
	private static void search( int n , int day , int price ){

		if( day >= n ){
			answer = Math.max( answer, price );
			return;
		}
		int d = consult[day][0];
		int p = consult[day][1];

		if( day + d -1 < n )
			search(n, day + d , price + p );
		search(n,day+1,price);

	}
}

