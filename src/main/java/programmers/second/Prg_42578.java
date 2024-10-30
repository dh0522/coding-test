package programmers.second;

import java.util.HashMap;

public class Prg_42578 {
	public static void main(String[] args) {
		Prg_42578 sol = new Prg_42578();

		String[][] clothes = {{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(sol.solution( clothes ));
	}
	private static int solution( String[][] clothes ){
		HashMap<String, Integer> hm = new HashMap<>();
		for( int i =0; i < clothes.length; i++ ){
			String cloth = clothes[i][0];
			String category = clothes[i][1];

			hm.put( category , hm.getOrDefault( category , 0 )+1 );
		}

		if( hm.size() == 1 ){
			return clothes.length;
		}

		int answer = 1;

		for( String key : hm.keySet() ){
			answer *= (hm.get(key)+1);
		}

		answer -= 1;

		return answer;
	}
}
