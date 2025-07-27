package programmers.second;

public class Prg_340212 {
	public static void main(String[] args) {

		Prg_340212 sol = new Prg_340212();

		System.out.println(sol.solution(new int[]{1, 5, 3 }, new int[]{ 2, 4, 7} , 30));
		
	}
	private static int solution(int[] diffs, int[] times, long limit){
		int answer = 0;

		int left = 1;
		int right = 0;
		for(int i = 0; i < diffs.length; i++){
			right = Math.max(right, diffs[i]);
		}


		while(left <= right){
			int mid = (left+right)%2 == 0 ? (left+right)/2 : (left+right)/2 + 1;
			long sum = 0;

			for(int i = 0; i < diffs.length; i++){
				if( diffs[i] <= mid){
					sum += times[i];
				}
				else{
					sum += (diffs[i] - mid)*(times[i] + times[i-1]) + times[i];
				}
			}

			if(sum <= limit){
				answer = mid;
				right = mid - 1;
			}else {
				left = mid + 1;

			}

		}


		return answer;
	}
}
