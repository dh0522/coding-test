package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_17471 {
	static int n;
	static int answer = Integer.MAX_VALUE;
	static int[] people; // 구역의 인구수
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		people = new int[n + 1];
		visited = new boolean[n+1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		list = new ArrayList<>();
		for (int i = 0; i <= n; i++)
			list.add(new ArrayList<>());

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int nextNum = Integer.parseInt(st.nextToken());
			for (int j = 0; j < nextNum; j++) {
				list.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}

		/**
		 *
		 *  1. 두 선거구 로 나눌 수 있는지의 여부
		 */
		dfs(0);

		if( answer == Integer.MAX_VALUE )
			System.out.println(-1);
		else
			System.out.println(answer);

	}
	private static void dfs( int depth ){
		if( depth == n ){
			List<Integer> first = new ArrayList<>();
			List<Integer> second = new ArrayList<>();

			for( int i= 1; i <=n ; i++ ){
				if( visited[i] )
					first.add(i);
				else second.add(i);
			}

			if( first.isEmpty() || second.isEmpty() )
				return;

			if( isConnected(first ) && isConnected(second) ){
				int sum1 = 0;
				int sum2 = 0;
				for( int i = 1; i<= n ; i++ ){
					if( visited[i] )
						sum1 += people[i];
					else sum2+= people[i];
				}

				answer = Math.min (answer , Math.abs(sum1-sum2 ) );
			}
			return;

		}

		visited[depth] = true;
		dfs(depth+1);
		visited[depth] = false;
		dfs( depth +1 );
	}
	private static boolean isConnected( List<Integer> tmp  ){
		Queue<Integer> q = new LinkedList<>();
		q.add( tmp.get(0) );

		visited = new boolean[n+1];
		visited[tmp.get(0)] = true;

		while( !q.isEmpty() ){
			int now = q.poll();
			for( int i = 0;i < list.get(now).size() ; i++ ){
				int next = list.get(now).get(i);
				if( !visited[next] && tmp.contains(next) ){
					q.add( next );
					visited[next] =true;
				}
			}
		}
		for( int i : tmp ){
			if( !visited[i] )
				return false;
		}

		return true;

	}
}
