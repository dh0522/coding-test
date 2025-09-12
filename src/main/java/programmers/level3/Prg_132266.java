package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Prg_132266 {
	public static void main(String[] args) {
		Prg_132266 sol = new Prg_132266();
		System.out.println(Arrays.toString(sol.solution(3, new int[][] {{ 1, 2}, {2, 3}}, new int[] {2,3} , 1)));
	}
	private int[] solution(int n, int[][] roads, int[] sources, int destination) {
		int[] answer = new int[sources.length];
		List<List<Integer>> list = new ArrayList<>();

		for(int i = 0; i <= n; i++){
			list.add(new ArrayList<>());
		}

		for(int[] road: roads){
			int x = road[0];
			int y = road[1];

			list.get(x).add(y);
			list.get(y).add(x);
		}

		// bfs 로 destination -> 각 까지
		int[] distance = new int[n+1];
		Arrays.fill(distance, -1);

		Queue<Integer> q = new LinkedList<>();
		q.add(destination);
		distance[destination] = 0;

		while(!q.isEmpty()){
			int now = q.poll();

			for(int i = 0; i < list.get(now).size(); i++ ){
				int next = list.get(now).get(i);

				if(distance[next] != -1)
					continue;

				distance[next] = distance[now] + 1;
				q.add(next);
			}
		}

		for(int i = 0; i < sources.length; i++){
			answer[i] = distance[sources[i]];
		}

		return answer;
	}
}
