package programmers.second;

import java.util.Stack;

public class Prg_131704 {
	public static void main(String[] args) {

		Prg_131704 sol = new Prg_131704();
		System.out.println(sol.solution( new int[]{4, 3, 1, 2, 5 }));
		System.out.println(sol.solution( new int[]{5, 4, 3, 2, 1 }));
	}
	private static int solution( int[] order ){

		int answer = 0;
		Stack<Integer> sub = new Stack<>();

		int idx = 0;
		int now = 1; // 1~ n 까지의 값

		while( idx < order.length ){

			int want = order[idx];


			if( now == want ){
				answer++;
				idx++;
				now++;
			}else if( !sub.isEmpty() && sub.peek() == want ){
				answer++;
				idx++;
				sub.pop();


			}else if( !sub.isEmpty() && sub.peek() > want && want < now  ){
				break;
			}

			else {
				sub.push( now );
				now++;
			}



		}


		return answer;
	}
}
