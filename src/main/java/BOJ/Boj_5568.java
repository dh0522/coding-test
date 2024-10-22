package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Boj_5568 {
	static Set<Integer> set =new HashSet<>();
	static List<Integer> list = new ArrayList<>();
	static int n,k;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());

		visited = new boolean[n];
		for ( int i=0 ;i <n ; i++ )
			list.add( Integer.parseInt(br.readLine()) );

		dfs( k, 0 , "");
		System.out.println(set.size());
	}
	private static void dfs( int k , int depth , String temp ){

		if ( depth == k ){
			set.add( Integer.parseInt(temp) );
			return;
		}

		for ( int i =0; i < n ; i++ ){
			if (visited[i])
				continue;
			visited[i] = true;
			dfs( k , depth+1 , temp+String.valueOf(list.get(i)) );
			visited[i] = false;
		}

	}
}
