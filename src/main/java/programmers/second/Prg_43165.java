package programmers.second;

public class Prg_43165 {
	public static void main(String[] args) {
		Prg_43165 sol = new Prg_43165();
		System.out.println(sol.solution( new int[]{1, 1, 1, 1, 1} , 3 ));

		System.out.println(sol.solution( new int[]{4, 1, 2, 1} , 4 ));
	}
	static int answer;
	private static int solution(int[] numbers, int target ){
		answer = 0;
		dfs( 0, 0 , target , numbers );
		return answer;
	}
	private static void dfs( int sum , int idx , int target , int[] numbers ){

		if( idx == numbers.length ){
			if( sum == target )
				answer++;
			return;
		}

		dfs( sum - numbers[idx] , idx+1 , target, numbers );
		dfs( sum + numbers[idx] , idx+1 , target, numbers );


	}
}
