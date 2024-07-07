package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Boj_11403 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] graph = new int[n+1][n+1];

		StringTokenizer st;
		for( int i = 1; i <= n; i++ ){
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n ; j++ ){
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for( int k = 1; k < n+1 ; k++ ){
			for( int i = 1; i < n+1; i++ ){
				for( int j =1 ; j< n+1; j ++ ){
					if( graph[i][k] == 1 && graph[k][j] == 1 )
						graph[i][j] = 1;
				}
			}
		}

		for (int i= 1; i <= n; i++ ){
			for(int j= 1; j<= n ;j++ )
				System.out.print(graph[i][j] +" ");
			System.out.println();
		}
	}
}
