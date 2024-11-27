package programmers.second;

import java.util.PriorityQueue;

public class Prg_42626 {
	public static void main(String[] args) {
		Prg_42626 sol = new Prg_42626();
		System.out.println(sol.solution( new int[]{1, 2, 3, 9, 10, 12}, 7 ));
	}

	private static int solution( int[] scoville , int K ){
		int answer = 0;


		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for( int i : scoville )
			pq.add(i);


		while( true ){

			if( pq.peek() >= K )
				break;
			if( pq.size() == 1 )
				return -1;

			int first = pq.poll();
			int second = pq.poll();

			int newSco = first + second*2;
			pq.add(newSco);

			answer++;
		}


		return answer;
	}
}
