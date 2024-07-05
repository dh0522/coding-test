package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_13549 {
	public static void main(String[] args) throws  Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader( System.in ));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		bfs(n , k );
	}
	private static void bfs( int soobin , int sister ){

		Queue<Integer> q = new LinkedList<>();
		int[] visited = new int[100001];

		q.add(soobin);
		visited[soobin] = 1;

		while( !q.isEmpty() ){

			int now = q.poll();
			if( now == sister ){
				System.out.println(visited[now]-1);
				return;
			}

			if( now*2 < 100001 && visited[now*2] == 0 ){
				visited[now*2] = visited[now];
				q.add(now*2);
			}
			if( now - 1 >= 0 && visited[now-1] == 0 ){
				visited[now-1] = visited[now] +1;
				q.add(now-1);
			}
			if( now +1 < 100001 && visited[now+1] == 0 ){
				visited[now+1] = visited[now] + 1;
				q.add(now+1);
			}

		}

		return;

	}
}
