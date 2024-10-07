package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Boj_1744 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> negative = new PriorityQueue<>(Collections.reverseOrder());

		boolean zero = false;
		for (int i=0; i<n; i++ ) {
			int now = Integer.parseInt(br.readLine());

			if ( now > 0 )
				positive.add( now );
			else if( now == 0 )
				zero = true;
			else
				negative.add( now );
		}


		long answer = 0;

		if ( zero && negative.size() % 2 != 0 )
			negative.poll();
		if (negative.size()%2 != 0 )
			answer += negative.poll();

		while( !negative.isEmpty() ){
			answer += negative.poll()*negative.poll();

		}

		while( !positive.isEmpty() ){

			if( positive.size() == 1 ){
				answer += positive.poll();
			}else{
				int first = positive.poll();
				int second = positive.poll();

				if( first == 1 || second == 1 ){
					answer += first + second;
				}else{
					answer += first*second;
				}

			}

		}


		System.out.println(answer);
	}
}
