package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_15686 {
	static List<int[]> home = new ArrayList<>();
	static List<int[]> chicken = new ArrayList<>();
	static int n,m;
	static int answer = 1000000000;
	static int[][] town;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		town = new int[n][n];

		for( int i =0 ; i< n ; i++ ){
			st = new StringTokenizer(br.readLine());
			for( int j = 0 ; j < n ; j ++ ){
				 town[i][j] = Integer.parseInt(st.nextToken());
				 if( town[i][j] == 1 ){
					 home.add( new int[]{i,j} );
				 }else if( town[i][j] == 2 ){
					 chicken.add(new int[]{i,j});
				 }
			}
		}

		boolean[] visited = new boolean[ chicken.size() ];

		for( int i = 0; i < chicken.size(); i++ ){
			visited[i] = true;
			dfs( i , 1  , visited );
			visited[i] = false;
		}

		System.out.println(answer);

	}
	private static void dfs( int idx , int count , boolean[] visited ){

		if( count == m ){
			answer = Math.min( answer , calc( visited ) );
			return;
		}

		for( int i = idx+1; i < chicken.size(); i++ ){
			visited[i] = true;
			dfs( i , count+1, visited );
			visited[i] = false;
		}
	}

	private static int calc(boolean[] visited){

		List<int[]> list = new ArrayList<>();
		for( int i = 0; i < visited.length ; i++ ){
			if( visited[i] ){
				list.add( chicken.get(i) );
			}
		}

		int sum = 0;

		for( int j= 0; j < home.size(); j ++ ){
			int[] nowHome = home.get(j);
			int dis = 1000000000;

			for( int i =0 ; i < m; i++ ){
				int[] nowChicken = list.get(i);
				dis = Math.min( dis, Math.abs( nowHome[0]-nowChicken[0] ) + Math.abs(nowHome[1] - nowChicken[1] ) );
			}

			sum += dis;
		}
		return sum;
	}
}
















