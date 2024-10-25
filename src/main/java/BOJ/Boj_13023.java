package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_13023 {
	static int n,m;
	static boolean check = false;
	static boolean[] visited;
	static List<List<Integer>> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for ( int i=0; i < n; i++ )
			list.add( new ArrayList<>() );



		for ( int i=0; i < m ;i++ ){
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list.get(a).add(b);
			list.get(b).add(a);

		}

		visited = new boolean[n];
		for ( int i=0; i < n; i++ ){

			dfs( i , 0 );
			if (check){
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);

	}
	private static void dfs( int now , int depth ){

		if( depth == 4 ) {
			check = true;
			return;
		}

		visited[now] = true;
		for( Integer i : list.get(now) ){
			if (visited[i])
				continue;
			dfs( i , depth+1 );
		}

		visited[now] = false;
	}
}
