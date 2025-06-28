package programmers.second;

public class Prg_140107 {
	public static void main(String[] args) {
		Prg_140107 sol = new Prg_140107();
		System.out.println(sol.solution(2, 4));
		System.out.println(sol.solution(1, 5));
	}
	private static long solution( int k, int d ) {
		long answer = 0;

		for (int x = 0; x <= d; x += k) {

			long diff = (long)Math.sqrt((long)d * d - (long)x * x); // 16

			long cnt = diff / k + 1;

			answer += cnt;

		}
		return answer;
	}
}
