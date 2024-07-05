package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1697 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		bfs( n, k );
	}
	private static void bfs( int n , int k ){

		Queue<Integer> q = new LinkedList<>();
		q.add( n );
		int[] visited = new int[100001];
		visited[n] = 1;

		while( !q.isEmpty()) {

			int now = q.poll();
			if( now == k ){
				System.out.println(visited[now] -1 );
				return;
			}

			for( int i= 0 ; i < 3; i++ ){
				int next;

				if( i == 0 )
					next = now + 1;
				else if( i==1 )
					next = now-1;
				else next = now*2;

				if(  next >= visited.length || next < 0  || visited[next] != 0 )
					continue;

				visited[next] = visited[now] + 1;
				q.add(next);
			}

		}

	}
}
