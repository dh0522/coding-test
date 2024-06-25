package programmers;

public class Prg_12905 {
	public static void main(String[] args) throws Exception {

		Prg_12905 sol = new Prg_12905();
		int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};

		System.out.println(sol.solution( board ));
	}
	private static int solution(int[][] board ){

		int n = board.length;
		int m = board[0].length;


		for( int i =1; i<n ;i ++ ){
			for( int j =1; j< n ;j ++ ){
				if( board[i][j] == 1 ){
					board[i][j] = Math.min ( Math.min ( board[i-1][j], board[i][j-1] ) , board[i-1][j-1] ) + 1;
				}
			}
		}
		int answer = 0;
		for( int i = 0; i <n ; i++ ){
			for( int j =0 ; j < m; j++ )
				answer = Math.max(answer , board[i][j]);
		}
		return answer*answer;
	}
}
