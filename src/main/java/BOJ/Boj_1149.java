package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1149 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] cost = new int[n+1][3];

		StringTokenizer st;
		for( int i = 1 ; i <= n ; i++ ){
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			cost[i][0] = Math.min( cost[i-1][1] , cost[i-1][2] ) + r;
			cost[i][1] = Math.min( cost[i-1][0] , cost[i-1][2] ) + g;
			cost[i][2] = Math.min( cost[i-1][0] , cost[i-1][1] ) + b;

		}

		System.out.println(Math.min(Math.min( cost[n][0] ,cost[n][1]),cost[n][2]));


	}
}













