package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_13913 {
	static int answer = Integer.MAX_VALUE;
	static int[] visited;
	public static void main(String[] args) throws  Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		visited = new int[100001];
		bfs( n , k );


	}
	private static void bfs( int n , int k ){

		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		int[] parent = new int[100001];

		visited[n] = 1;

		while( !q.isEmpty() ){
			int now = q.poll();

			if( now == k ){
				answer = visited[now] -1;
				break;
			}

			for( int i = 0 ; i< 3; i ++ ){
				int next;

				if( i == 0 )
					next = now *2;
				else if( i==1 )
					next = now +1;
				else next = now-1;

				if( next < 0 || next >= 100001 || visited[next] != 0 )
					continue;

				q.add(next);
				visited[next] = visited[now] +1;
				parent[next] = now;
			}
		}

		System.out.println(answer);
		int idx = k;
		Stack<String> stk = new Stack<>();

		while( idx != n ){

			stk.push( String.valueOf(idx) );
			idx = parent[idx];
		}
		stk.push(String.valueOf(n));

		while( !stk.isEmpty()) {
			System.out.print(stk.pop()+" ");
		}



	}
}
