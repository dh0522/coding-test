package programmers.level3;

import java.util.Arrays;
import java.util.Comparator;

public class Prg_42884 {
	public static void main(String[] args) {
		Prg_42884 sol = new Prg_42884();

		System.out.println(sol.solution(new int[][] {{ -20,-15}, {-14,-5}, {-18,-13}, {-5,-3 }}));
	}
	private int solution(int[][] routes) {

		int answer = 1;
		Arrays.sort(routes, new Comparator<>() {
			@Override
			public int compare(int[] o1, int[] o2){
				return o1[1] - o2[1];
			}
		});

		int camera = routes[0][1];
		for(int i = 1; i < routes.length; i++){

			if(camera < routes[i][0]){
				answer++;
				camera = routes[i][1];
			}
		}

		return answer;
	}
}
