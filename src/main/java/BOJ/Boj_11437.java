package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_11437 {
	static int[] parent, depth;
	static List<List<Integer>> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		for( int i =0;i <=n ; i++ )
			list.add( new ArrayList<>() );

		for( int i =0; i <n-1; i++ ){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list.get(a).add(b);
			list.get(b).add(a);
		}

		parent = new int[n+1];
		depth = new int[n+1];

		dfs( 1, 1 , 0 );


		StringBuilder sb = new StringBuilder();
		int m = Integer.parseInt(br.readLine());
		for( int i=0; i <m ;i ++ ){
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			sb.append(search(x,y)).append("\n");
		}

		System.out.println(sb.toString());

	}
	private static void dfs( int now , int dep , int par ){

		depth[now] = dep;
		parent[now] = par;

		for( Integer next : list.get(now) ){
			if( next == par )
				continue;
			dfs( next , dep+1 , now );
		}


	}
	private static int search( int x , int y ){

		int xheight = depth[x];
		int yheight = depth[y];

		while( xheight > yheight ){
			x = parent[x];
			xheight--;
		}
		while( yheight > xheight ){
			y = parent[y];
			yheight--;
		}

		while( x != y ){
			x = parent[x];
			y = parent[y];
		}

		return x;

	}
}
