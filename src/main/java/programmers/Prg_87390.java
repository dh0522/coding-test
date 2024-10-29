package programmers;

public class Prg_87390 {
	public static void main(String[] args) {

		Prg_87390 sol = new Prg_87390();
		int[] answer = sol.solution(3,2,5);

		for ( Integer i : answer )
			System.out.print( i+" ");
		System.out.println();
	}
	private static int[] solution(int n, long left, long right) {


		int[] answer = new int[ (int)(right-left) + 1 ];

		long row = left/n;
		long col = left%n;

		for( int i = 0; i < answer.length ; i++ ){

			int num = Math.max( (int)row+1, (int)col+1 );
			answer[i] = num;

			col++;
			if( col%n == 0 ){
				col = 0;
				row++;
			}

		}
		return answer;
	}
}
