package programmers.second;

public class Prg_388352 {
	public static void main(String[] args) {
		Prg_388352 sol = new Prg_388352();

		System.out.println(sol.solution(10, new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {3, 7, 8, 9, 10}, {2, 5, 7, 9, 10}, {3, 4, 5, 6, 7} } , new int[] {2, 3, 4, 3, 3}));
	}
	static int[][] comb;
	static int[] numb;
	static int answer =0, m;
	private static int solution(int n, int[][] q, int[] ans) {
		answer = 0;

		m = q.length;

		comb = new int[m][5];
		numb = new int[m];

		numb = ans.clone();

		for(int i=0; i <m; i++){
			comb[i] = q[i].clone();
		}


		boolean[] check = new boolean[n+1];
		dfs( 0, 1, check);

		return answer;
	}
	private static void dfs(int depth, int idx, boolean[] check){
		if(depth == 5){

			isSecretCode(check);
			return;
		}


		for(int i= idx; i < check.length; i++ ){
			if(check[i])
				continue;

			check[i] = true;
			dfs(depth+1, i, check);
			check[i] = false;
		}
	}


	private static void isSecretCode(boolean[] check){


		for(int i=0; i <m; i++){

			int cnt = 0;
			for(int j=0; j< 5; j++){
				if( check[comb[i][j]] ){
					cnt++;
				}
			}

			if(cnt != numb[i])
				return;

		}

		answer++;

		return;
	}
}
