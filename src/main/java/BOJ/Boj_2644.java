package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_2644 {
	static int n;
	static int findA,findB;
	static boolean[] visited;
	static int answer =-1;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		visited = new boolean[n+1];

		for( int i =0 ;i <= n; i++ )
			list.add( new ArrayList<>());

		StringTokenizer st = new StringTokenizer(br.readLine());

		findA = Integer.parseInt(st.nextToken());
		findB = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine());



		for( int i= 0; i < m ; i++ ){
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt( st.nextToken() );
			int y = Integer.parseInt( st.nextToken() );

			list.get(x).add(y);
			list.get(y).add(x);

		}

		dfs(findA , 0);

		System.out.println(answer);

	}
	public static void dfs( int people ,  int depth ){

		visited[people] = true;

		for( int i =0 ;i < list.get(people).size(); i++ ){
			int now = list.get(people).get(i);

			if( !visited[now] ){
				if( now == findB ){
					answer = depth+1;
					return;
				}
				dfs( now , depth+1 );
			}

		}

	}
}
