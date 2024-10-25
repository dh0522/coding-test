package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Boj_2668 {
	static int n;
	static int[][] arr;
	static boolean[] visited;
	static boolean[] check;
	static Set<Integer> list = new HashSet<>();
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new int[n][2];
		for ( int i=0; i < n; i++ ){
			arr[i][0] = i;
			arr[i][1] = Integer.parseInt(br.readLine())-1;
		}

		check = new boolean[n];

		for( int i=0; i< n; i++ ){
			visited = new boolean[n];
			if ( arr[i][0] == arr[i][1] ){
				check[i] = true;
				list.add( arr[i][0]+1 );

			}
			if (!check[i])
				dfs( arr[i][0] , i ,0 );
		}

		List<Integer> temp = new ArrayList<>(list);
		Collections.sort( temp );

		StringBuilder sb = new StringBuilder();
		sb.append(temp.size()).append("\n");
		for( Integer i : temp )
			sb.append(i).append("\n");

		System.out.println(sb);

	}
	private static void dfs( int start , int idx, int depth ){

		if( start == arr[idx][1] ){

			for ( int i =0; i < n;i ++ ){
				if ( visited[i] ){
					check[i] = true;
					list.add(i+1);
				}
			}
			return;
		}

		if ( depth == n )
			return;

		visited[idx] = true;
		dfs( start , arr[idx][1] ,depth+1 );
	}
}
