package programmers;

import java.util.List;
import java.util.ArrayList;

public class Prg_12936 {
	public static void main(String[] args) {
		Prg_12936 sol = new Prg_12936();
		int[] ans = sol.solution( 3, 5);

		for( int i : ans)
			System.out.print(i+" ");
		System.out.println();
	}

	private static int[] solution( int n, long k ) {

		List<Integer> list = new ArrayList<>();

		long total = 1;
		for( int i=1; i<= n; i++ ){
			list.add(i);
			total *= i;
		}

		int[] answer = new int[n];
		int idx = 0;
		k--; // idx =0 에서 시작하기 때문에

		while( !list.isEmpty() ){

			// 맨 앞 수가 n인 것의 갯수
			long block = total/list.size();

			// k번째의 첫번째 수가 무엇인지
			int firstOrder = (int)(k/block);

			// total = 24/6 = 4;
			total /= list.size();

			answer[idx++] = list.remove(firstOrder);
			k = k%block;

		}

		return answer;
	}
}
