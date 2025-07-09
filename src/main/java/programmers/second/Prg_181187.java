package programmers.second;

public class Prg_181187 {
	public static void main(String[] args) {
		Prg_181187 sol = new Prg_181187();

		System.out.println(sol.solution(2,3));
	}

	private static long solution(int r1, int r2){
		long answer = 0;
		
		long min = (long)r1*r1;
		long max = (long)r2*r2;

		for(int i =1; i < r2; i++){

			int num = (int)Math.ceil(Math.sqrt(min - (long)i*i));
			int num2 = (int)Math.floor(Math.sqrt(max - (long)i*i));

			int cnt = num2-num+1;

			if( num == 0 )
				cnt--;
			answer += cnt;
		}

		answer *= 4;
		answer += (r2-r1+1)*4;

		return answer;
	}
}
