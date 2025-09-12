package programmers.level3;

public class Prg_161988 {
	public static void main(String[] args) {
		Prg_161988 sol = new Prg_161988();

		System.out.println(sol.solution(new int[] {  2, 3, -6, 1, 3, -1, 2, 4 }));

	}
	private long solution(int[] sequence) {

		long[] first = new long[sequence.length];
		long[] second = new long[sequence.length];

		int one = 1;
		for(int i = 0; i < sequence.length; i++){
			first[i] = sequence[i]*one;
			one *= -1;
			second[i] = sequence[i]*one;
		}

		long firstMax = 0;
		long secondMax = 0;

		long ans1 = firstMax;
		long ans2 = secondMax;


		for(int i =0; i < first.length; i++){

			first[i] = Math.max(firstMax + first[i], first[i]);
			firstMax = first[i];
			ans1 = Math.max(ans1, firstMax);

			second[i] = Math.max(secondMax + second[i] , second[i]);
			secondMax = second[i];
			ans2 = Math.max(ans2, secondMax);

		}


		return Math.max(ans1, ans2);
	}
}
