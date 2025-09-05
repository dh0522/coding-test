package programmers.level3;

import java.util.Collections;
import java.util.PriorityQueue;

public class Prg_12927 {
	public static void main(String[] args) {
		Prg_12927 sol = new Prg_12927();

		System.out.println(sol.solution(new int[]{4,3,3}, 4));
		System.out.println(sol.solution(new int[]{2,1,2}, 1));
	}
	private static long solution( int[] works, int n ){
		long answer = 0;

		int allWork = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for(int work : works){
			allWork += work;
			pq.add(work);
		}

		if(allWork <= n){
			return 0;
		}


		while(true){
			if( n == 0 )
				break;

			int now = pq.poll();
			int diff = now - pq.peek();

			if(diff == 0){
				pq.add(now-1);
				n--;

			}else if( diff <= n ){
				now -= diff;
				n -= diff;
				pq.add(now);
			}else{
				now -= n;
				pq.add(now);
				break;
			}
		}

		while(!pq.isEmpty()){
			answer += Math.pow(pq.poll(), 2);
		}


		return answer;
	}
}
