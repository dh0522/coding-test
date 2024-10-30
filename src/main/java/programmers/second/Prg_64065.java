package programmers.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prg_64065 {
	public static void main(String[] args) {
		Prg_64065 sol = new Prg_64065();

		System.out.println(Arrays.toString(sol.solution("{{20,111},{111}}")));
		System.out.println(Arrays.toString(sol.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
	}

	private static int[] solution( String s ){

		s = s.replaceAll("\\{","").replaceAll("\\}}","");
		String[] strArr = s.split("},");

		Arrays.sort( strArr , (String s1 , String s2) -> s1.length() - s2.length());
		List<Integer> list = new ArrayList<>();

		for( String str: strArr ){
			String[] tempArr = str.split(",");
			for( String tmp : tempArr ){
				int num = Integer.parseInt( tmp );
				if( !list.contains(num) ){
					list.add( num );
				}
			}
		}

		return list.stream().mapToInt(Integer::intValue).toArray();

	}
}
