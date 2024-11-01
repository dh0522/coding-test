package programmers.second;

import java.util.ArrayList;
import java.util.List;

public class Prg_17677 {
	public static void main(String[] args) {
		Prg_17677 sol = new Prg_17677();

		System.out.println(sol.solution( "FRANCE" , "french" ));
	}
	private static int solution(String str1 , String str2 ){

		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();

		for( int i=0; i < str1.length()-1 ; i ++ ){
			if( !Character.isLetter(str1.charAt(i)) || !Character.isLetter( str1.charAt(i+1) ) )
				continue;
			String temp = str1.substring( i, i+2 );
			list1.add( temp );
		}

		int union = list1.size();
		int inter=0;

		for( int i=0; i < str2.length()-1 ; i ++ ){
			if( !Character.isLetter(str2.charAt(i)) || !Character.isLetter( str2.charAt(i+1) ) )
				continue;
			String temp = str2.substring( i, i+2 );
			list2.add( temp );

			if( list1.contains(temp) ){
				list1.remove( list1.indexOf( temp) );
				inter++;
			}
		}

		if( union == 0 && list2.isEmpty() )
			return 65536;

		union += list2.size() - inter ;



		return (inter*65536)/union;
	}
}
