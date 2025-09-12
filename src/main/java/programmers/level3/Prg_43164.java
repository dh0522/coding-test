package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prg_43164 {
	public static void main(String[] args) {
		Prg_43164 sol = new Prg_43164();
		System.out.println(Arrays.toString(sol.solution(new String[][]{{"ICN", "JFK"},{"HND", "IAD"},{"JFK", "HND"}})));
		System.out.println(Arrays.toString(sol.solution(new String[][]{{"ICN", "BBB"},{"BBB", "ICN"},{"ICN", "AAA"}})));
	}
	static String[] realAns ;
	private String[] solution(String[][] tickets) {
		String[] answer = new String[tickets.length + 1];
		realAns = new String[answer.length];

		Map<String, List<Airport>> map = new HashMap<>();

		for(String[] ticket : tickets){
			String start = ticket[0];

			if(map.containsKey(start)){
				map.get(start).add(new Airport(ticket[1], false));
				Collections.sort(map.get(start));
			}else{
				map.put(start, new ArrayList<>());
				map.get(start).add(new Airport(ticket[1], false));
			}
		}

		answer[0] = "ICN";
		dfs(map, answer, "ICN", 0);



		return realAns;
	}
	private static void dfs(Map<String, List<Airport>> map, String[] answer, String now, int depth){

		if(depth == answer.length-1){
			realAns = answer.clone();
			return;
		}

		if( !map.containsKey(now) || map.get(now).isEmpty())
			return;

		for(int i = 0; i < map.get(now).size(); i++){
			Airport next = map.get(now).get(i);

			if(next.check)
				continue;

			answer[depth+1] = next.name;
			next.check = true;

			dfs(map, answer, next.name, depth+1);

			next.check = false;
		}
	}
}

class Airport implements Comparable<Airport>{
	String name;
	boolean check;

	public Airport(String name, boolean check){
		this.name = name;
		this.check = check;
	}

	@Override
	public int compareTo(Airport o1){
		return o1.name.compareTo(this.name);
	}
}
