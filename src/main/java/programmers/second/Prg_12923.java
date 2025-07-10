package programmers.second;

import java.util.Arrays;

public class Prg_12923 {

	public static void main(String[] args) {
		Prg_12923 sol = new Prg_12923();

		System.out.println(Arrays.toString(sol.solution(1, 10)));
	}

	private int[] solution(long begin, long end) {

		int idx = (int)(end-begin);
		int[] answer = new int[idx+1];

		idx = 0;
		for(long i = begin ; i <= end; i++ ){

			int ans = 1;

			for( int j = 2; j <= (int) Math.sqrt(i) ; j ++){

				if( i == j )
					break;

				if( i % j != 0 )
					continue;

				long quotient = i / j;

				if( quotient > 10000000 ){
					ans = Math.max(j, ans) ;
				}else {
					ans = Math.max( ans, Math.max(  j, (int)quotient ));
				}

			}

			answer[idx++] = ans;


		}

		if(begin == 1)
			answer[0] = 0;


		return answer;
	}
}
