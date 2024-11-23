package programmers.second;

import java.util.Arrays;

public class Prg_42584 {
	public static void main(String[] args) {
		Prg_42584 sol = new Prg_42584();
		System.out.println(Arrays.toString( sol.solution(new int[]{1,2,3,2,3})));
	}
	private static int[] solution( int[] prices ){
		int[] answer = new int[prices.length];
		// 가격이 떨어지지 않은 기간
		// 동일해도 상관X

		for( int i =0; i < prices.length -1 ;i ++ ){
			int now = prices[i];
			int cnt = 0;
			for( int j = i+1; j < prices.length; j++ ){
				if( now <= prices[j] )
					cnt++;
				else{
					cnt++;
					break;
				}
			}
			answer[i] = cnt;
		}
		answer[prices.length-1] = 0;
		return answer;
	}
}
