package programmers.level3;

public class Prg_43162 {
	public static void main(String[] args) {
		Prg_43162 sol = new Prg_43162();

		System.out.println(sol.solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1 }}));
		System.out.println(sol.solution(3, new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1 }}));
	}
	private static int solution(int n, int[][] computers){
		int answer = 0;

		boolean[] check = new boolean[n];
		for(int i = 0; i < n; i++){
			if(check[i])
				continue;

			check[i] = true;
			dfs(i, check, computers);
			answer++;
		}
		return answer;
	}
	private static void dfs(int now, boolean[] check, int[][] computers){

		for(int i = 0; i < check.length; i++){
			if( i == now || check[i])
				continue;

			if(computers[now][i] == 1){
				check[i] = true;
				dfs(i, check, computers);
			}

		}
	}
}
