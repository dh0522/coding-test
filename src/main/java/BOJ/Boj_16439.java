package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16439 {
	static int n,m;
	static int[][] arr;
	static boolean[] yes;
	static int answer = Integer.MIN_VALUE;
	public static void main(String[] args)  throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 회원 수
		m = Integer.parseInt(st.nextToken()); // 치킨 종류의 수
		/**
		 * 	  n명의 고리회원 -> 치킨 주문
		 * 	  m가지 종류의 치킨
		 * 	  선호도가 가장 큰 값
		 *
		 */

		arr = new int[n][m];
		yes = new boolean[m];

		for ( int i=0; i < n; i++ ){
			st = new StringTokenizer(br.readLine());
			for ( int j=0; j < m ; j++ )
				arr[i][j] = Integer.parseInt(st.nextToken());
		}


		searchMax ( 0 , 0 );
		System.out.println(answer);

	}
	private static void searchMax( int depth , int idx ){
		if ( depth == 3 ){
			int sum = 0;
			for( int i =0; i < n; i++ ){
				int num = 0;
				for ( int j = 0; j < m ; j++ ){
					if ( !yes[j] )
						continue;
					num = Math.max( num, arr[i][j] );
				}
				sum += num;
			}
			answer = Math.max( sum , answer );
			return;
		}


		for ( int i = idx  ; i < m ; i++ ){
			if ( yes[i] )
				continue;

			yes[i] = true;
			searchMax( depth+1 , i  );
			yes[i] = false;
		}
	}
}
