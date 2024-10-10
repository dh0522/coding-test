package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj_1715 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i=0; i <n; i++ ){
			pq.add( Integer.parseInt(br.readLine()) );
		}

		int answer = 0;
		while( pq.size() != 1 ){
			int now = pq.poll();
			int next = pq.poll();
			answer += now+next;
			pq.add(now+next);
		}

		System.out.println( answer );



	}
}
