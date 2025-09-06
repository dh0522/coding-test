package programmers.level3;

import java.util.Arrays;

public class Prg_12987 {
	public static void main(String[] args) {
		Prg_12987 sol = new Prg_12987();

		System.out.println(sol.solution(new int[]{5,1,3,7}, new int[]{2,2,6,8}));
		System.out.println(sol.solution(new int[]{2,2,2,2}, new int[]{1,1,1,1}));
	}

	private static int solution(int[] A, int[] B){
		int answer = 0;

		Arrays.sort(A); // 1, 3, 5, 7
		Arrays.sort(B); // 2, 2, 6, 8

		int idx = 0;
		for(int i = 0; i < B.length; i++){
			if(A[idx] < B[i]){
				answer++;
				idx++;
			}
		}

		return answer;
	}
}
