package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1461 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> minusBook = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> plusBook = new PriorityQueue<>(Collections.reverseOrder());
		st = new StringTokenizer(br.readLine());

		for (int i=0; i <n ; i++ ) {
			int now = Integer.parseInt(st.nextToken());
			if( now < 0 )
				minusBook.add(Math.abs(now));
			else plusBook.add(now);
		}

		int count = 0;

		PriorityQueue<Integer> distance = new PriorityQueue<>();

		while( !minusBook.isEmpty() ){
			int now = minusBook.poll();
			if( count == 0 )
				distance.add( now );
			count++;
			if( count == m ){
				count = 0;
			}
		}

		count = 0;
		while( !plusBook.isEmpty() ){
			int now = plusBook.poll();
			if( count == 0 )
				distance.add( now );
			count++;
			if( count == m ){
				count = 0;
			}
		}

		int answer = 0;
		while( distance.size() != 1 ){
			int dis = distance.poll();
			answer += dis*2;
		}
		answer += distance.poll();
		System.out.println( answer );


	}
}
