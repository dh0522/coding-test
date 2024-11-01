package programmers.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Prg_17684 {
	public static void main(String[] args) {
		Prg_17684 sol = new Prg_17684();

		System.out.println(Arrays.toString( sol.solution("KAKAO") ));
		System.out.println(Arrays.toString(sol.solution("TOBEORNOTTOBEORTOBEORNOT")));
	}
	private static int[] solution( String msg  ){
		HashMap< String, Integer > hm = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		String[] arr = msg.split("");


		int number = 27;
		for( int i = 0; i < msg.length(); i ++ ){

			String tmp = arr[i];
			String temp = arr[i];

			int idx = i;

			for( int j = i+1; j < msg.length(); j++ ){
				temp += arr[j];
				if( !hm.containsKey( temp ) )
					break;
				tmp += arr[j];
				idx = j;
			}

			if( i == idx ){
				list.add( msg.charAt(i) - 'A' + 1 );
				hm.put( temp , number++ );

			}else{
				list.add( hm.get(tmp) );
				hm.put( temp , number++ );

			}
			i = idx;
		}
		return list.stream().mapToInt(i->i).toArray();
	}
}
