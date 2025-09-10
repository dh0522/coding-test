package programmers.level3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Prg_49189 {
	public static void main(String[] args) {
		Prg_49189 sol = new Prg_49189();
		System.out.println(sol.solution(6, new int[][] {{ 3, 6} , {4, 3} , {3, 2} , {1, 3} , {1, 2} , {2, 4} , {5, 2 }}));
	}

	private static int solution(int n, int[][] edge){
		int answer = 0;
		List<List<Integer>> list = new ArrayList<>();

		for(int i = 0; i <= n; i++ ){
			list.add(new ArrayList<>());
		}

		for(int i = 0; i < edge.length; i++){
			int x = edge[i][0];
			int y = edge[i][1];

			list.get(x).add(y);
			list.get(y).add(x);
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(1);

		int[] arr = new int[n+1];
		arr[1] = 1;


		while(!q.isEmpty()){
			int now = q.poll();

			for(int i = 0; i < list.get(now).size(); i++){
				int num = list.get(now).get(i);

				if(arr[num] != 0)
					continue;

				arr[num] = arr[now] + 1;
				q.add(num);
			}
		}

		int max = arr[1];
		for(int i : arr){
			max = Math.max(i, max);
		}

		for(int i: arr){
			if(max == i)
				answer++;
		}


		return answer;
	}

}
