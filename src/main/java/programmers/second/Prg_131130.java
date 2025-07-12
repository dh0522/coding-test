package programmers.second;

import java.util.LinkedList;
import java.util.Queue;

public class Prg_131130 {
	public static void main(String[] args) {
		Prg_131130 sol = new Prg_131130();

		System.out.println(sol.solution( new int[]{ 8,6,3,7,2,5,1,4 }));
	}
	static int answer;
	private int solution(int[] cards) {

		answer = Integer.MIN_VALUE;

		// bfs == Queue 이용하는 것 같음
		for(int i = 0; i < cards.length; i++){
			search(cards, i);
		}

		return answer == Integer.MIN_VALUE ? 0 : answer;
	}
	private static void search(int[] cards, int start){
		Queue<Integer> q = new LinkedList<>();
		boolean[] check = new boolean[cards.length];

		int first = 0;
		q.add(cards[start]-1);
		// 1. 첫번째

		while(!q.isEmpty()){
			int now = q.poll();
			if( check[now] )
				break;

			check[now] = true;
			int next = cards[now]-1;
			first ++;
			q.add(next);
		}

		if( cards.length == first ){
			return;
		}

		int finalSecond = 0;

		for(int i = 0 ; i < cards.length; i++){
			if(check[i])
				continue;

			boolean[] temp = check.clone();
			int second = 0;

			q.add(cards[i] - 1);

			while(!q.isEmpty()){
				int now = q.poll();
				if( temp[now] )
					break;

				temp[now] = true;
				int next = cards[now]-1;
				second ++;
				q.add(next);
			}

			finalSecond = Math.max(second, finalSecond);
		}

		answer = Math.max(answer, first*finalSecond);

	}
}
