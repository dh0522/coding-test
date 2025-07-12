package programmers.second;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prg_131130_2 {
	public static void main(String[] args) {
		Prg_131130_2 sol = new Prg_131130_2();

		System.out.println(sol.solution(new int[]{8,6,3,7,2,5,1,4}));
	}
	private int solution(int[] cards) {
		int size = cards.length;
		boolean[] check = new boolean[size];

		List<Integer> list = new ArrayList<>();

		for(int i=0; i< size; i++){
			int cnt = 0;
			int now = cards[i]-1;

			while(!check[now]){
				check[now] = true;
				cnt ++;
				now = cards[now]-1;
			}

			list.add(cnt);
		}

		Collections.sort(list, Collections.reverseOrder());


		return list.get(0)*list.get(1);
	}
}
