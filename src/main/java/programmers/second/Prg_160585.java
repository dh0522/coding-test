package programmers.second;

public class Prg_160585 {
	public static void main(String[] args) {
		Prg_160585 sol = new Prg_160585();

		System.out.println(sol.solution(new String[]{ "O.X", ".O.", "..X" }));
		System.out.println(sol.solution(new String[]{ "OOO", "...", "XXX" }));
		System.out.println(sol.solution(new String[]{"...", "...", "..." }));
		System.out.println(sol.solution(new String[]{"...", ".X.", "..." }));
	}
	private int solution(String[] board) {

		int oCnt = 0;
		int xCnt = 0;


		for(int i = 0;i < 3; i++){
			for(int j=0; j< 3; j++ ){
				if( board[i].charAt(j) == 'X')
					xCnt ++;
				else if( board[i].charAt(j)== 'O')
					oCnt++;
			}
		}

		if(xCnt > oCnt || Math.abs(xCnt-oCnt) >= 2 )
			return 0;

		boolean xPoss = check(board, 'X');
		boolean oPoss = check(board, 'O');

		if( xPoss && oPoss )
			return 0;

		else if( oPoss && xCnt +1 != oCnt )
			return 0;
		else if( xPoss && xCnt != oCnt )
			return 0;


		return 1;

	}

	private static boolean check(String[] board, char ch){


		String str = "";
		for(int i =0; i< 3; i++)
			str += String.valueOf(ch);

		// 가로
		for(int i =0; i< 3; i++ ){
			if(board[i].equals(str))
				return true;
		}

		// 세로
		for(int y = 0; y< 3; y++){
			String tmp = "";

			for(int x = 0; x < 3; x++){
				tmp += String.valueOf( board[x].charAt(y) );
			}
			if( tmp.equals(str))
				return true;
		}


		// 대각선
		String tmp1 = "";
		String tmp2 = "";

		for(int i =0; i < 3; i++){
			tmp1 += String.valueOf( board[i].charAt(i)) ;
			tmp2 += String.valueOf( board[i].charAt(2-i) );
		}

		if( tmp1.equals(str) || tmp2.equals(str) )
			return true;

		return false;


	}
}
