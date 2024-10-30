package programmers.second;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Prg_42628 {
	public static void main(String[] args) {
		Prg_42628 sol = new Prg_42628();
		System.out.println( Arrays.toString( sol.solution( new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"} )));
	}
	private static int[] solution( String[] operations ){

		PriorityQueue<Integer> minQ = new PriorityQueue<>();
		PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());

		for( int i=0; i < operations.length; i++ ){

			String[] op = operations[i].split(" ");

			if( op[0].equals( "I" ) ){
				minQ.add( Integer.parseInt(op[1]));
				maxQ.add( Integer.parseInt(op[1]));

			}
			else if( op[1].equals("1") && !maxQ.isEmpty() ){
				minQ.remove( maxQ.poll()) ;
			}else{
				if( !minQ.isEmpty() )
					maxQ.remove( minQ.poll()) ;
			}
		}

		if( minQ.isEmpty() && maxQ.isEmpty() )
			return new int[]{0,0};

		return new int[]{maxQ.poll(),minQ.poll()};

	}
}
