package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_5014 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int u = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		/**
		 *
		 *   건물 층 수 : f 층
		 *   강호가 있는 층 : S층 -> G층 가고싶음
		 *   u : 위로 갈 수 있는 층 수
		 *   d : 밑으로 갈 수 있는 층 수
		 */

		int[] building = new int[f+1];
		int[] updown = {u,-d};

		building[s] = 1;

		Queue<Integer> q = new LinkedList<>();
		q.add( s );

		int answer = -1;

		while(!q.isEmpty()){

			int now = q.poll();

			if( now == g ) {
				answer = building[now] -1;
				break;
			}

			for( int i = 0 ; i <2 ; i++ ){
				int next = now + updown[i];
				if( next <= 0 || f < next ||building[next] != 0  )
					continue;

				building[next] = building[now] + 1;
				q.add(next);
			}

		}

		if( answer == -1 )
			System.out.println("use the stairs");
		else
			System.out.println(answer);

	}
}
