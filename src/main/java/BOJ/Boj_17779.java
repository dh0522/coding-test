package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_17779 {
	static int n;
	static int[] people;
	static boolean[] visited;
	static int answer = Integer.MAX_VALUE;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt( br.readLine());
		people = new int[n+1];
		visited = new boolean[n+1];

		for( int i =0; i <=n ; i++ )
			list.add( new ArrayList<>() );

		StringTokenizer st = new StringTokenizer(br.readLine());
		for( int i=1; i <= n ; i++ ){
			people[i] = Integer.parseInt(st.nextToken());
		}

		for( int i =1 ; i<= n ; i++ ){
			st = new StringTokenizer(br.readLine());
			int adjPeople = Integer.parseInt(st.nextToken());
			for( int j=0; j <adjPeople; j++ ){
				list.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}

		dfs(0 );

		if( answer == Integer.MAX_VALUE )
			System.out.println(-1);
		else
			System.out.println(answer);

	}
	private static void dfs( int idx ){
		if( idx == n ){

			List<Integer> list1 = new ArrayList<>();
			List<Integer> list2 = new ArrayList<>();

			for( int i=1 ; i<= n; i++ ){
				if( visited[i] )
					list1.add( i );
				else list2.add(i );
			}

			if( list1.isEmpty() || list2.isEmpty() )
				return;

			if( isConnect(list1) && isConnect(list2) ){
				int sum1 = 0;
				int sum2 = 0;

				for( int i =1; i<=n ; i++ ){
					if( visited[i] )
						sum1 += people[i];
					else sum2+= people[i];
				}

				answer = Math.min( answer , Math.abs(sum1 - sum2 ) );
			}
			return;
		}

		visited[idx] = true;
		dfs( idx+1 );
		visited[idx] = false;
		dfs(idx+1 );


	}

	private static boolean isConnect( List<Integer> list1 ){

		boolean[] connect = new boolean[n+1];

		Queue<Integer> q = new LinkedList<>();
		q.add(list1.get(0));
		connect[list1.get(0)] = true;

		while( !q.isEmpty() ) {
			int num = q.poll();

			for( int i=0; i < list.get(num).size(); i++ ){
				int next = list.get(num).get(i);
				if( connect[next] )
					continue;
				if( !list1.contains(next) )
					continue;

				connect[next] = true;
				q.add(next);
			}
		}
		for( int tmp : list1 ){
			if( !connect[tmp] )
				return false;
		}
		return true;
	}
}
