package programmers.second;

import java.util.Collections;
import java.util.PriorityQueue;

public class Prg_142085 {
	public static void main(String[] args) {
		Prg_142085 sol = new Prg_142085();
		System.out.println(sol.solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1}));
	}

	private int solution(int n, int k, int[] enemy) {
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for(int i=0; i < enemy.length; i++){

			pq.add(enemy[i]);
			n -= enemy[i];

			if( n < 0 && k == 0 ){
				break;
			}

			if( n < 0 && k > 0 && ( pq.peek() + n >= 0 ) ){

				k--;
				n += pq.poll();

			}


			answer = i+1;
		}


		return answer;
	}
}
