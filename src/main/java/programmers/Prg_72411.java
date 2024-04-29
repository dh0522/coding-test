package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Prg_72411 {
	public static void main(String[] args) {



		Prg_72411 sol = new Prg_72411();

		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};

		String[] result = sol.solution( orders, course);

		for( String ans : result )
			System.out.print(ans +" ");
		System.out.println();
	}
	private HashMap<String, Integer> hm = new HashMap<>();
	private String[] solution(String[] orders , int[] course){

		List<String> list = new ArrayList<>();

		for( String order : orders ){

			char[] charArr = order.toCharArray();
			boolean[] visited = new boolean[charArr.length];
			Arrays.sort( charArr );

			for( int j  =0 ; j < course.length; j ++ ){

				if( charArr.length >= course[j] ){

					combi( charArr, visited , 0 , course[j] );
				}

			}
		}

		for( int len : course ){

			int max = 0;
			for( String key : hm.keySet() ){

				if( key.length() == len ) {

					if (hm.get(key) > max) {
						max = hm.get(key);
					}

				}
			}
			for( String key : hm.keySet()){

				if( len == key.length() && hm.get(key) > 1 && hm.get(key) == max )
					list.add(key);
			}

		}
		Collections.sort(list);
		return list.toArray( new String[list.size()] );


	}

	private void combi( char[] charArr, boolean[] visited , int start , int len ){

		if( len == 0 ){
			StringBuilder sb = new StringBuilder();
			for( int i  = 0 ;i < visited.length; i ++ ){

				if( visited[i] )
					sb.append( charArr[i] );
			}

			String key = sb.toString();
			hm.put( key, hm.getOrDefault( key , 0 )+1 );
			return;
		}

		for( int i = start; i < charArr.length; i++ ){
			visited[i] = true;
			combi( charArr, visited, i+1, len-1);
			visited[i] = false;
		}


	}
}
