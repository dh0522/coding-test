package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Prg_340211 {
	public static void main(String[] args) {
		Prg_340211 sol = new Prg_340211();

		System.out.println(
			sol.solution(
				new int[][] { {3, 2}, {6, 4}, {4, 7}, {1, 4} },
				new int[][] { {4, 2}, {1, 3}, {2, 4} }
			)
		);
	}

	private static int solution(int[][] points, int[][] routes) {
		int answer = 0;

		Map<String, List<Integer>> map = new HashMap<>();

		for(int i =0; i< routes.length; i++){

			int x = points[routes[i][0]-1][0];
			int y = points[routes[i][0]-1][1];

			int[] move = {x,y};
			int distance = 0;

			String key = move[0]+" "+ move[1];
			if( !map.containsKey( key ) ){
				map.put(key, new ArrayList<>());
			}

			map.get(key).add(distance++);

			for( int j = 1; j < routes[i].length; j++ ){
				int idx = routes[i][j]-1;

				int wantX = points[idx][0];
				int wantY = points[idx][1];

				x = move[0];
				y = move[1];

				for(int k = 0; k < Math.abs(wantX-x); k++) {

					move[0] = (wantX-x) > 0 ? move[0]+1 : move[0]-1;
					key = move[0]+" "+ move[1];

					if( !map.containsKey( key ) ){
						map.put(key, new ArrayList<>());
					}

					map.get(key).add(distance++);
				}

				for(int k = 0; k < Math.abs(wantY - y); k++) {

					move[1] = (wantY - y) > 0 ? move[1]+1 : move[1]-1;
					key = move[0]+" "+ move[1];

					if( !map.containsKey( key ) ){
						map.put(key, new ArrayList<>());
					}

					map.get(key).add(distance++);
				}
			}
		}

		for( String key : map.keySet()){
			if( map.get(key).size() == 1)
				continue;

			Set<Integer> set = new HashSet<>( map.get(key) );

			if(set.size() < map.get(key).size() ){
				Map<Integer, Integer> values = new HashMap<>();
				for(Integer i : map.get(key)){
					values.put(i, values.getOrDefault(i, 0) + 1 );
				}


				for(Integer i: values.keySet()){
					if(values.get(i) >= 2)
						answer++;
				}

			}
		}
		return answer;
	}
}
