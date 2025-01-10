package programmers.second;

public class Prg_17679 {
	public static void main(String[] args) {
		Prg_17679 sol = new Prg_17679();
		System.out.println(sol.solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
		System.out.println(sol.solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
	}
	static char[][] chBoard;
	static boolean[][] check;
	static int[] dx = {1,0,1};
	static int[] dy = {0,1,1};
	private static int solution( int m, int n, String[] board ){

		int num = 0;
		int answer = 0;
		chBoard = new char[board.length][board[0].length()];

		for( int i = 0; i < board.length; i++ ){
			chBoard[i] = board[i].toCharArray();
		}

		while( true ){

			check = new boolean[board.length][board[0].length()];

			// 검사
			for( int i =0; i < chBoard.length; i++ ){
				for( int j=0; j < chBoard[i].length; j++ ){
					if( chBoard[i][j] != '#' && chBoard[i][j] <= 'Z' && 'A' <= chBoard[i][j] )
						searchFourBlock(i, j);
				}
			}

			// 지우기
			num = eraseBlock();
			if( num == 0 )
				break;
			answer += num;

			// 내리기
			downBlock();

		}
		return answer;
	}
	private static void downBlock(){

		StringBuilder sb ;

		for( int i = 0; i < chBoard[0].length; i++ ){

			sb = new StringBuilder();

			for( int j = chBoard.length-1; j >= 0 ; j-- ){
				if( chBoard[j][i] != '#' )
					sb.append(chBoard[j][i]);
			}

			while( sb.length() != chBoard.length ){
				sb.append("#");
			}

			sb = sb.reverse();
			for( int j = chBoard.length-1; j >= 0; j-- ){
				chBoard[j][i] = sb.toString().charAt(j);
			}

		}


	}
	private static int eraseBlock(){
		int count = 0;

		for( int i =0; i < chBoard.length; i++ ){
			for( int j=0; j < chBoard[0].length; j++ ){
				if( check[i][j] ){
					chBoard[i][j] = '#';
					count++;
				}
			}
		}

		return count;
	}

	private static void searchFourBlock(int x, int y){

		int nx = 0;
		int ny = 0;
		char now = chBoard[x][y];

		for( int i = 0; i < 3; i++ ){
			nx = x + dx[i];
			ny = y + dy[i];
			if( nx < 0 || ny < 0 || nx >= chBoard.length || ny >= chBoard[0].length )
				return;
			if( chBoard[nx][ny] != now )
				return;
		}

		check[x][y] = true;
		for( int i = 0; i < 3; i++ ){
			nx = x + dx[i];
			ny = y + dy[i];

			check[nx][ny] = true;
		}
	}
}
