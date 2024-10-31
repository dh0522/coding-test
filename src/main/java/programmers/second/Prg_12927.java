package programmers.second;

import java.util.Collections;
import java.util.PriorityQueue;

public class Prg_12927 {
	public static void main(String[] args) {
		Prg_12927 sol = new Prg_12927();

		System.out.println(sol.solution( new int[]{4,3,3} , 4 ) );


	}
	private static long solution( int[] works , int n ){
		long answer = 0;
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		for( Integer i : works )
			q.add(i);

		while( n > 0 ){

			int max = q.poll();
			if( max == 0 ) {
				break;
			}
			if( q.isEmpty() ){
				q.add( max-n );
				break;
			}

			int exMax = q.peek();

			int diff = max-exMax;
			if( diff == 0 ){
				q.add( max-1 );
				n--;
			}

			else{
				if( diff <= n ){
					if( max - diff != 0 )
						q.add( max - diff );
					n-= diff;
				}else{
					if( max - n != 0 )
						q.add( max - n );
					n = 0;
				}

			}
		}

		while( !q.isEmpty() ){
			answer += Math.pow( q.poll()  , 2 );
		}

		return answer;
	}
}
