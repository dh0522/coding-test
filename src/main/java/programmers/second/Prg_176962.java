package programmers.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Prg_176962 {
	public static void main(String[] args) {
		Prg_176962 sol = new Prg_176962();

		System.out.println(Arrays.toString( sol.solution(new String[][]{ {"korean", "11:40", "30"},{"english", "12:10", "20"},{"math", "12:30", "40"}})) );
		System.out.println(Arrays.toString(sol.solution(new String[][]{ {"science", "12:40", "50"}, {"music", "12:20", "40"},{"history", "14:00", "30"},{"computer", "12:30", "100"}})) );
		System.out.println(Arrays.toString( sol.solution(new String[][]{ {"aaa", "12:00", "20"}, {"bbb", "12:10", "30"},{"ccc", "12:40", "10" }})) );
	}
	private String[] solution(String[][] plans) {
		String[] answer = new String[plans.length];

		List<Plan> list = new ArrayList<>();
		for(String[] plan: plans){
			int time = Integer.parseInt(plan[1].split(":")[0])*60 + Integer.parseInt(plan[1].split(":")[1]);
			list.add(new Plan(plan[0],time,Integer.parseInt(plan[2])));
		}

		// 1.수업 시작이 작은 순으로 정렬
		Collections.sort(list);

		Queue<Plan> order = new LinkedList<>(list);
		Stack<Plan> wait = new Stack<>();
		int idx = 0;

		while( !order.isEmpty() ){

			Plan now = order.poll();
			Plan next = order.peek();

			if( next == null ){
				answer[idx++] = now.name;
			}

			else if( now.startTime + now.playTime < next.startTime ){
				answer[idx++] = now.name;
				if(wait.isEmpty() )
					continue;

				int resTime = next.startTime - now.playTime - now.startTime ;
				while(resTime > 0 && !wait.isEmpty() ){
					Plan prev =  wait.pop();

					if(resTime >= prev.playTime){
						answer[idx++] = prev.name;
						resTime -= prev.playTime;
					}
					else{
						wait.add(new Plan(prev.name, 0, prev.playTime - resTime));
						resTime = 0;
					}
				}


			}else if( now.startTime + now.playTime == next.startTime ){
				answer[idx++] = now.name;
			}else{
				wait.push(new Plan(now.name, 0,  now.playTime - (next.startTime - now.startTime) ));
			}

		}

		while(!wait.isEmpty()){
			Plan now = wait.pop();
			answer[idx++] = now.name;
		}


		return answer;
	}
}

class Plan implements Comparable<Plan> {
	String name;
	int startTime;
	int playTime;

	public Plan(String name, int startTime, int playTime){
		this.name = name;
		this.startTime = startTime;
		this.playTime = playTime;
	}

	@Override
	public int compareTo(Plan o1){
		return this.startTime - o1.startTime;
	}

	@Override
	public String toString(){
		return this.name+" "+ this.startTime +" "+ this.playTime;
	}
}
