package programmers.second;

import java.util.Arrays;
import java.util.Comparator;

public class Prg_42746 {
	public static void main(String[] args) {
		Prg_42746 sol = new Prg_42746();

		System.out.println(sol.solution( new int[]{6, 10, 2}));
		System.out.println(sol.solution( new int[]{ 3, 30, 34, 5, 9 }));
	}
	private static String solution( int[] numbers ){

		boolean zeroCheck = true;

		String[] strArray = new String[numbers.length];
		for( int i = 0; i < numbers.length; i++ ){
			if( numbers[i] != 0 )
				zeroCheck = false;

			strArray[i] = String.valueOf( numbers[i] );
		}

		if( zeroCheck )
			return "0";

		Arrays.sort( strArray , new Comparator<>(){
			@Override
			public int compare(String o1, String o2){

				String one = o1 + o2;
				String two = o2 + o1;

				return two.compareTo(one);

			}
		});

		StringBuilder sb = new StringBuilder();
		for( String str: strArray ){
			sb.append(str);
		}



		return sb.toString();
	}
}
