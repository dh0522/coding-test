package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14501 {
	static int answer = 0;
	static int[][] arr;
	static int n;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		arr = new int[n+1][2];
		for( int i = 1; i <= n ; i++ ){
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			arr[i][0] = time;
			arr[i][1] = cost;

		}

		for( int i =1; i<= n ; i++ ){
			dfs( i+arr[i][0]-1 , arr[i][1] );
		}
		System.out.println(answer);
	}
	private static void dfs( int date , int tmpCost ){
		if( date > n )
			return;
		answer = Math.max( answer , tmpCost );
		for( int i = date+1 ; i <= n; i++ ){
			dfs( i + arr[i][0]-1 , tmpCost + arr[i][1] );
		}


	}
}
