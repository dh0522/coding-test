package programmers.level3;

public class Prg_64062 {
	public static void main(String[] args) {
		Prg_64062 sol = new Prg_64062();

		System.out.println(sol.solution(new int[] {2, 4, 5, 3, 2, 1, 4, 2, 5, 1 } , 3 ));
	}
	private int solution(int[] stones, int k) {

		int answer = 0;

		int min = 1;
		int max = stones[0];


		for(int stone: stones){
			min = Math.min(min, stone);
			max = Math.max(max, stone);
		}

		while(min <= max){

			int mid = (min+max)/2;
			boolean check = cross(stones, k, mid);
			if(check){
				min = mid+1;
				answer = mid;
			}else{
				max = mid - 1;
			}
		}


		return answer+1;
	}
	private static boolean cross(int[] stones, int k, int mid){
		int jump = 0;

		for(int i = 0; i < stones.length; i++){

			if(stones[i] - mid <= 0){
				jump ++;
			}else{
				jump = 0;
			}

			if(jump == k)
				return false;
		}


		return true;
	}
}
