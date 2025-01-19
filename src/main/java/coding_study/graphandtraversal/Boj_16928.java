package coding_study.graphandtraversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16928 {

	static int[] board = new int[101];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 사다리 수
		int m = Integer.parseInt(st.nextToken()); // 뱀의 수

		int start = 0;
		int end = 0;


		for ( int i = 0; i < n+m; i++ ){
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());

			board[start] = end;
		}

		System.out.println(bfs());

	}
	private static int bfs(){

		int next = 0;
		Queue<Integer> q = new ArrayDeque<>();
		int[] visited = new int[101];

		Arrays.fill( visited,  100 );

		q.add( 1 );
		visited[1] = 0;

		while( !q.isEmpty() ){
			int now = q.poll();

			if ( board[now] != 0 ){
				next = board[now];
				if( visited[next] < visited[now] + 1 )
					continue;

				visited[next] = visited[now] + 1;
				q.add( next );
				continue;
			}

			for ( int i =1; i <= 6; i++ ){

				next = now + i;
				if ( next > 100 )
					continue;

				if( visited[next] <= visited[now] + 1 )
					continue;

				q.add( next );
				visited[next] = visited[now] + 1;
			}

		}

		return visited[100]-1;
	}
}
