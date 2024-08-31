package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_17471 {
	static int[] people;
	static int answer = Integer.MAX_VALUE;
	static int n;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		people = new int[n+1];
		visited = new boolean[n+1];

		for( int i=0; i <=n ; i++ ){
			list.add( new ArrayList<>() );
		}

		StringTokenizer st = new StringTokenizer(br.readLine());

		for( int i=1; i <= n; i ++ ){
			people[i] = Integer.parseInt(st.nextToken());
		}

		for( int i=1; i <= n; i++ ){
			 st = new StringTokenizer(br.readLine());
			 int num = Integer.parseInt(st.nextToken());

			 for( int j=0; j < num ; j++ ){
				 list.get(i).add( Integer.parseInt(st.nextToken() ));
			 }
		}

		dfs( 0 );

		System.out.println( answer == Integer.MAX_VALUE ? -1 : answer );
	}
	private static void dfs( int idx ){

		if( idx == n ) {
			List<Integer> list1 = new ArrayList<>();
			List<Integer> list2 = new ArrayList<>();

			for (int i = 1; i <= n; i++) {
				if (visited[i])
					list1.add(i);
				else
					list2.add(i);
			}

			if (list1.size() == 0 || list2.size() == 0)
				return;

			if( isTwoPart(list1) && isTwoPart(list2) ){
				int sum1 = 0;
				int sum2 = 0;

				for (int i=1; i <=n ;i ++ ){
					if (visited[i])
						sum1 += people[i];
					else sum2 += people[i];
				}

				answer = Math.min ( answer , Math.abs(sum1-sum2) );
			}
			return;
		}

		visited[idx] = true;
		dfs(idx+1);
		visited[idx] = false;
		dfs( idx +1 );


	}
	private static boolean isTwoPart( List<Integer> one ){

		// 두 부분으로 나뉜 구역이 정말 서로 인접한 애들끼리만 되어있는지

		boolean[] tmp = new boolean[n+1];
		Queue<Integer> q = new LinkedList<>();

		q.add( one.get(0) );
		tmp[ one.get(0) ] = true;

		while( !q.isEmpty() ){
			int now = q.poll();

			for( int i=0; i < list.get(now).size(); i++ ){

				int next = list.get(now).get(i);
				if( tmp[next] )
					continue;
				if( !one.contains(next) )
					continue;

				tmp[next] = true;
				q.add(next);

			}
		}

		for( int i : one ){
			if( !tmp[i] )
				return false;
		}

		return true;
	}
}
