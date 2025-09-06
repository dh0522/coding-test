package programmers.level3;

import java.util.Arrays;

public class Prg_12938 {
	public static void main(String[] args) {
		Prg_12938 sol = new Prg_12938();

		System.out.println(Arrays.toString(sol.solution(2,9)));
		System.out.println(Arrays.toString(sol.solution(2,1)));
		System.out.println(Arrays.toString(sol.solution(2,8)));
	}
	private int[] solution(int n, int s) {

		if(s < n)
			return new int[]{-1};

		int[] answer = new int[n];
		int idx = 0;
		while(n > 0){
			int max = s/n;
			answer[idx++] = max;
			s -= max;
			n--;
		}

		return answer;
	}

}
