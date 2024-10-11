package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10971 {
	static int answer = Integer.MAX_VALUE;
	static boolean[] check;
	static int[][] city;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		city = new int[n][n];
		for (int i=0;i <n; i++ ){
			st = new StringTokenizer(br.readLine());
			for (int j=0; j < n; j++ )
				city[i][j] = Integer.parseInt(st.nextToken());

		}

		check = new boolean[n];
		dfs(0 , 0 , 0 );
		System.out.println( answer == Integer.MAX_VALUE ? 0 : answer );
	}

	private static void dfs( int now , int depth , int sum ){
		if( depth == city.length-1 ){

			if( city[now][0] == 0 )
				return;

			for (int i=1 ; i < city.length;i++ ){
				if( !check[i] )
					return;
			}

			answer = Math.min( answer , sum + city[now][0] );
			return;
		}

		for ( int i=1 ; i < city.length  ; i++ ){

			if ( city[now][i] == 0 || check[i] )
				continue;

			check[i] = true;
			dfs( i, depth+1 , sum+city[now][i] );
			check[i] = false;

		}
	}
}
