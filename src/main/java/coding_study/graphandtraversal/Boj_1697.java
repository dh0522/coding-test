package coding_study.graphandtraversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1697 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		if (n == m){
			System.out.println(0);
			return;
		}

		int[] move = {1,-1,2};

		Queue<Integer> q = new ArrayDeque<>();
		int[] visited = new int[100001];
		Arrays.fill(visited, Integer.MAX_VALUE );

		int now = n;
		int next = n;

		q.add(n);
		visited[n] = 0;

		while(!q.isEmpty()){
			now = q.poll();

			for ( int i = 0; i < 3; i++ ){
				if( i == 2 ){
					next = now * move[i];
				}else{
					next = now + move[i];
				}

				if ( next < 0 || next >= visited.length )
					continue;

				if (visited[next] <= visited[now] + 1 )
					continue;

				visited[next] = visited[now]+1;
				q.add(next);
			}

		}

		System.out.println(visited[m]);
	}
}
