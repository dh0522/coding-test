package SamsungSWTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14889 {
	static private int[][] power ;
	static private int answer= Integer.MAX_VALUE;
	static private boolean[] visited ;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = n/2;
		visited = new boolean[n];


		power = new int[n][n];
		StringTokenizer st;
		for( int i =0 ;i <n ;i ++ ){
			st  = new StringTokenizer(br.readLine());
			for(int j= 0; j < n ;j++ ) {
				power[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		// 능력의 차이를 최소로 하기 위함이다.
		// 그 때 이 최소의 값을 구하여라
		// dfs ? 완전탐색 문제

		search( 0 ,0 , count );

		System.out.println(answer);

	}
	private static void search( int n,  int depth , int count ) {

		if( depth == count ){
			getSum();
			return;
		}
		for( int i = n ; i < power.length ; i ++ ){
			if( visited[i] )
				continue;

			visited[i] = true;
			search( i +1 , depth+1 , count );
			visited[i] = false;
		}

	}
	private static void getSum(){

		int tempsum = 0;
		int temp2sum = 0;

		for( int i = 0 ; i < power.length -1 ; i++ ){
			for( int j = i+1 ; j < power.length ; j++ ){

				if( visited[i]  && visited[j]  ){
					tempsum += power[i][j]+ power[j][i];
				}

				else if( !visited[i] && !visited[j] ){

					temp2sum += power[i][j] + power[j][i];
				}

			}
		}

		answer = Math.min ( answer , Math.abs(temp2sum-tempsum) );
	}
}
