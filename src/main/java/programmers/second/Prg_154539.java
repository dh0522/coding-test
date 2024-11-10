package programmers.second;

import java.util.Arrays;
import java.util.Stack;

public class Prg_154539 {
	public static void main(String[] args) {
		Prg_154539 sol = new Prg_154539();

		System.out.println(Arrays.toString( sol.solution( new int[] {2, 3, 3, 5} ) ));
		System.out.println(Arrays.toString( sol.solution( new int[] {9, 1, 5, 3, 6, 2} ) ));
	}

	private static int[] solution( int[] numbers ){

		int[] answer = new int[numbers.length];
		Arrays.fill( answer , -1 );

		Stack<Integer> stk = new Stack<>();

		for(int i=0; i < numbers.length; i++ ){


			while(!stk.isEmpty() && numbers[stk.peek()] < numbers[i] ){
				answer[stk.pop()] = numbers[i];
			}

			stk.push(i);
		}


		return answer;

	}
}
