package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14889 {
	static int[][] arr;
	static int n;
	static int answer = Integer.MAX_VALUE;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		visited = new boolean[n];
		arr = new int[n][n];

		for( int i =0; i <n ; i++ ){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j< n; j++ ){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}

		}

		dfs(0 , 0 );

		System.out.println(answer);
	}
	private static void dfs( int now,  int count ){

		if( count ==  n/2 ){
			calc();
			return;
		}

		for (int i = now; i < n ;i ++ ){
			if( visited[i] )
				continue;
			visited[i] = true;
			dfs( i+1, count+1 );
			visited[i] = false;

		}
	}
	private static void calc( ) {

		int firstTeam = 0;
		int secondTeam = 0;

		for( int i = 0 ;i < n; i ++ ){
			for( int j =i+1 ;j < n ; j ++ ){

				if( visited[i] && visited[j] ){
					firstTeam += arr[i][j] +  arr[j][i];
				}
				else if( !visited[i] && !visited[j] ){
					secondTeam += arr[i][j]+ arr[j][i];
				}
			}
		}
		answer = Math.min( answer , Math.abs(firstTeam-secondTeam) );

	}
}
