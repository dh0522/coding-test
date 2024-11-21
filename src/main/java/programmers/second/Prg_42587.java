package programmers.second;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Prg_42587 {
	public static void main(String[] args) {
		Prg_42587 sol = new Prg_42587();
		System.out.println(sol.solution( new int[]{2,1,3,2}, 2) );
		System.out.println(sol.solution( new int[]{1, 1, 9, 1, 1, 1}, 0) );
	}
	private static int solution( int[] priorities , int location ){
		PriorityQueue<Integer> pq = new PriorityQueue<>( Collections.reverseOrder() );
		Queue<Integer> q = new LinkedList<>();

		for( int i : priorities ){
			pq.add ( i );
			q.add( i );
		}

		int answer = 0;
		while( true ){

			if( pq.peek() != q.peek() ){

				q.add( q.poll() );
				location --;
				if( location == -1 )
					location += q.size();
			}
			else{ // pq.peek()== q.peek();

				pq.poll();
				q.poll();
				location --;
				answer++;
			}

			if( location == -1 )
				break;

		}


		return answer;
	}
}
