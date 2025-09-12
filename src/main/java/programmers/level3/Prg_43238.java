package programmers.level3;

public class Prg_43238 {
	public static void main(String[] args) {
		Prg_43238 sol = new Prg_43238();
		System.out.println(sol.solution(6, new int[]{7,10}));
	}
	private long solution(int n, int[] times) {

		long answer = 0;
		long start = 0;
		long end = Long.MAX_VALUE;

		while(start <= end){

			long mid = (start+end) / 2;

			long people = 0;

			for(int i = 0; i < times.length; i++){
				people += mid/ (long)times[i];
				if(people >= n)
					break;
			}

			if(people < n){
				start = mid + 1;
			}else{
				answer = mid;
				end = mid - 1;
			}
		}

		return answer;
	}
}
