package programmers;

import java.util.Arrays;

public class Prg_340198 {
	public static void main(String[] args) {
		Prg_340198 sol = new Prg_340198();

		int[] mats = {5,3,2};
		String[][] park = {{"A", "A", "-1", "B", "B", "B", "B", "-1"},{"A", "A", "-1", "B", "B", "B", "B", "-1"},
							{"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"}, {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
							{"D", "D", "-1", "-1", "-1", "-1", "-1", "F"}, {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}};

		System.out.println(sol.solution( mats, park ));
	}
	private int solution(int[] mats, String[][] park) {

		int answer = -1;
		Arrays.sort( mats );

		for( int i = mats.length-1; i >=0; i-- ){
			if( isPossible( mats[i], park) ){
				answer = mats[i];
				break;
			}
		}

		return answer;
	}

	private static boolean isPossible( int matSize, String[][] park ){

		for( int i =0; i <= park.length-matSize; i++ ){
			for( int j =0; j <= park[0].length-matSize; j++ ){
				if( !park[i][j].equals("-1") )
					continue;
				if( isSquare( i, j, matSize, park ) )
					return true;
			}
		}
		return false;
	}

	private static boolean isSquare( int x, int y, int matSize, String[][] park ){

		for( int i = x; i < x + matSize; i++ ){
			for( int j = y; j < y + matSize; j ++ ){

				if( !park[i][j].equals("-1") )
					return false;
			}
		}

		return true;
	}
}
