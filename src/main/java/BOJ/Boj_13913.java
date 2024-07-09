package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_13913 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] visited = new int[100001];
		int[] parent = new int[100001];

		visited[n] = 1;
		Queue<Integer> q = new LinkedList<>();
		q.add( n );
		int ans = 0;

		while( !q.isEmpty() ){

			int now = q.poll();
			if( now == k ){
				ans = visited[now] -1 ;
				break;
			}
			for( int i = 0 ; i < 3; i++ ){
				int next;
				if( i == 0 ){
					next = now + 1;
				}else if( i == 1){
					next = now -1;
				}else next = now*2;

				if( next < 0 || next >= visited.length || visited[next] != 0 )
					continue;

				parent[next] = now;
				q.add(next);
				visited[next] = visited[now] + 1;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(ans+"\n");
		List<Integer> list = new ArrayList<>();
		while( k != n ){
			list.add(k);
			k = parent[k];
		}
		sb.append(n+" ");
		for( int i = list.size()-1 ; i >=0 ; i-- ){
			sb.append(list.get(i) +" ");
		}
		System.out.println(sb.toString());

	}
}
