package programmers.second;

import java.util.List;
import java.util.ArrayList;

public class Prg_17680 {
	public static void main(String[] args) {
		Prg_17680 sol = new Prg_17680();
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		String[] cities2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};

		System.out.println(sol.solution( 3, cities ));
		System.out.println(sol.solution( 3, cities2 ));
	}
	private static int solution( int cacheSize, String[] cities) {
		int answer = 0;

		List<String> list = new ArrayList<>();

		for ( int i=0; i < cities.length; i++ ){
			String now = cities[i].toLowerCase();

			if( list.contains(now) ){
				answer++;
				list.remove( list.indexOf( now ) );
				list.add( now );

			}else if( list.size() < cacheSize ){
				answer += 5;
				list.add( now );
			}else{

				answer += 5;
				list.add(now);
				list.remove( 0 );

			}
		}


		return answer;
	}
}
