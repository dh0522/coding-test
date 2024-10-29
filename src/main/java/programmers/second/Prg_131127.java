package programmers.second;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Prg_131127 {
	public static void main(String[] args) {

		Prg_131127 sol = new Prg_131127();

		String[] want = {"banana", "apple", "rice", "pork", "pot"};
		int[] number = {3, 2, 2, 2, 1};
		String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

		String[] want2 = {"apple"};
		int[] number2 = {10};
		String[] discount2 = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};

		System.out.println(sol.solution( want , number, discount ));
		System.out.println(sol.solution( want2 , number2, discount2 ));
	}
	private static int solution(String[] want, int[] number, String[] discount) {

		HashMap<String,Integer> hm = new HashMap<>();
		for( int i=0; i < want.length; i++ ){
			hm.put( want[i] , number[i] );
		}

		int answer = 0;

		for( int i = 0; i <= discount.length - 10; i++ ){

			HashMap<String, Integer> tmp = new HashMap<>(hm);
			boolean check = true;
			for( int j =i ;j < i+10; j++ ){

				String now = discount[j];
				int count = tmp.getOrDefault( now , 0 )-1 ;
				if( count < 0 ){
					check = false;
					break;
				}
				tmp.put( now, count );
			}

			if( !check )
				continue;

			check = true;
			List<String> keySet = new ArrayList<>(tmp.keySet());
			for( String key : keySet ){

				if( tmp.get(key) != 0 ){
					check = false;
					break;
				}
			}

			if( check ){
				answer++;
			}

		}


		return answer;
	}
}
