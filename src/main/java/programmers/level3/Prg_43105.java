package programmers.level3;

public class Prg_43105 {
	public static void main(String[] args) {
		Prg_43105 sol = new Prg_43105();

		System.out.println(sol.solution(new int[][] {{7},{3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
	}
	private static int solution(int[][] triangle){
		int answer = 0;

		int n = triangle.length;

		int[][] sum = new int[n][n];
		for(int i = 0; i < n ; i++ ){
			sum[i] = triangle[i].clone();
		}

		for(int i = 1; i < triangle.length; i++){
			for(int j = 0; j <= i; j++ ){
				if(j == 0){
					sum[i][j] = sum[i-1][j] + triangle[i][j];

				}else if(i == j){
					sum[i][j] = sum[i-1][j-1] + triangle[i][j];

				}else{
					sum[i][j] = Math.max(sum[i-1][j-1] + triangle[i][j], sum[i-1][j] + triangle[i][j]);
				}


				answer = Math.max(answer, sum[i][j]);
			}
		}


		return answer;
	}
}
