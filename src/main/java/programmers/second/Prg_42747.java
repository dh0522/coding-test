package programmers.second;

import java.util.Arrays;

public class Prg_42747 {
	public static void main(String[] args) {
		Prg_42747 sol = new Prg_42747();
		System.out.println(sol.solution( new int[]{3,0,6,1,5} ) );
	}
	private static int solution( int[] citations ){
		Arrays.sort( citations );

		int answer = 0;
		for( int i = citations.length-1; i >=0 ; i -- ){
			int min = Math.min( citations[i] , citations.length - i );
			answer = Math.max( answer , min );
		}
		return answer;

	}
}
