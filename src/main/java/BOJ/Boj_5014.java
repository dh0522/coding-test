package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_5014 {
	static int f,s,g,u,d;
	static int[] visited;
	static int answer = -1;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		f = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		visited = new int[f+1];

		bfs( s );

		if( answer == -1 )
			System.out.println("use the stairs");
		else
			System.out.println(answer-1);
	}

	private static void bfs( int now ){

		Queue<Integer> q = new LinkedList<>();
		q.add(now);
		visited[now] = 1;


		while( !q.isEmpty() ){

			now = q.poll();

			if( now == g ){
				answer = visited[now];
				return;
			}

			if( isPossible(now+u ) ){;
				visited[now+u ]= visited[now]+1 ;
				q.add(now + u );
			}
			if ( isPossible(now-d) ) {
				visited[now -d]= visited[now]+1 ;
				q.add(now-d);
			}

		}


	}
	public static boolean isPossible( int next ){

		if( next <=0 || next > f || visited[next] != 0 )
			return false;
		return true;
	}
}
