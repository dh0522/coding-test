package programmers.level3;

public class Prg_42898 {
	public static void main(String[] args) {
		Prg_42898 sol = new Prg_42898();
		System.out.println(sol.solution(4, 3, new int[][] {{2,2}}));
	}
	private static int solution(int m, int n, int[][] puddles){
		int[][] town = new int[n+1][m+1];

		for (int i = 0; i < puddles.length; i++){
			int x = puddles[i][1];
			int y = puddles[i][0];

			town[x][y] = -1;
		}

		town[1][1] = 1;

		for (int i = 1; i <= n; i++){
			for (int j = 1; j <= m; j++){
				if (i == 1 && j == 1)
					continue;

				if (town[i][j] == -1) {
					town[i][j] = 0;
					continue;
				}

				town[i][j] = (town[i-1][j] + town[i][j-1]) % 1000000007;
			}
		}

		return town[n][m];
	}
}
