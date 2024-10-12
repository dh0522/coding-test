package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1389 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean[][] friends = new boolean[n][n];
		for (int i=0; i <m; i++ ){
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;

			friends[a][b] = true;
			friends[b][a] = true;
		}

		int man = 0;
		int min = Integer.MAX_VALUE;

		for (int i=0; i < n; i++ ){

			Queue<Integer> q = new LinkedList<>();
			q.add( i );

			int num = 0;
			int[] visited = new int[n];
			visited[i] = 1;

			while( !q.isEmpty() ){
				int now = q.poll();

				for (int j=0; j<n; j++ ){
					if ( visited[j] != 0 )
						continue;
					if ( !friends[now][j] )
						continue;

					visited[j] = visited[now]+1;
					num += (visited[j]-1);
					q.add( j );
				}
			}

			if ( min > num ){
				min = num;
				man = i;
			}

		}

		System.out.println(man+1);


	}
}
