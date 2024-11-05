package programmers;

import java.util.Arrays;

public class Prg_42577 {
	public static void main(String[] args) {
		Prg_42577 sol = new Prg_42577();
		System.out.println(sol.solution( new String[]{"119", "97674223", "1195524421"}));
	}

	private static boolean solution( String[] phone_book ){

		Arrays.sort( phone_book) ;

		for( int i=0; i <phone_book.length-1; i++ ) {
			String now = phone_book[i];

			if( phone_book[i+1].startsWith(now) ){
				return false;
			}
		}

		return true;
	}
}
