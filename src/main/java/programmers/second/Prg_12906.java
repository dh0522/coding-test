package programmers.second;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class Prg_12906 {
	public static void main(String[] args) {
		Prg_12906 sol = new Prg_12906();

		System.out.println( Arrays.toString( sol.solution( new int[]{1,1,3,3,0,1,1 }))) ;
	}
	private static int[] solution( int[] arr ){

		List<Integer> list = new ArrayList<>();
		Stack<Integer> stk = new Stack<>();

		stk.push( arr[0] );
		list.add( arr[0] );


		for( int i=1 ; i < arr.length; i++ ){

			if( stk.peek() == arr[i] )
				continue;

			stk.add( arr[i] );
			list.add( arr[i] );
		}


		return list.stream().mapToInt(i->i).toArray();
	}
}
