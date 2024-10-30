package programmers.second;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

public class Prg_42586 {
	public static void main(String[] args) {

		Prg_42586 sol = new Prg_42586();
		int[] progresses = {93, 30, 55};
		int[] speeds = {1,30,5};
		int[] progresses2 = {95, 90, 99, 99, 80, 99};
		int[] speeds2 = {1, 1, 1, 1, 1, 1};

		int[] answer1 = sol.solution( progresses , speeds );
		int[] answer2 = sol.solution( progresses2 , speeds2);


		for( Integer i : answer1 )
			System.out.print( i+" ");
		System.out.println();


		for( Integer i : answer2 )
			System.out.print( i+" ");
		System.out.println();
	}
	private static int[] solution(int[] progresses, int[] speeds) {

		Queue<Integer> q = new LinkedList<>();
		for( Integer i : progresses )
			q.add( i );

		int idx = 0;
		List<Integer> list = new ArrayList<>();
		while( !q.isEmpty() ){
			int firstDay = q.poll();
			int speed = speeds[idx];

			int day = (100-firstDay)/speed;
			if( (100-firstDay) % speed != 0  )
				day++;

			int count = 1;
			idx++;
			while( !q.isEmpty() ){
				int tmpPro = q.peek();
				if( tmpPro + speeds[idx]*day >= 100 ){
					count++;
					idx++;
					q.poll();
				} else{
					break;
				}
			}
			list.add(count);

		}

		int[] answer = new int[list.size()];
		for( int i=0; i < list.size(); i++ ){
			answer[i] = list.get(i);
		}


		return answer;
	}
}
