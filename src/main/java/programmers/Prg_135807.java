package programmers;

public class Prg_135807 {
	public static void main(String[] args) {
		Prg_135807 sol = new Prg_135807();

		int[] arrayA = {10,17};
		int[] arrayB = {5,20};

		System.out.println(sol.solution( arrayA , arrayB ));
	}

	private int solution (int[] arrayA , int[] arrayB) {
		int answer = 0;


		int gcdA = arrayA[0];
		int gcdB = arrayB[0];

		for( int i = 1; i< arrayA.length; i++ ){

			gcdA = gcd( arrayA[i], gcdA );
			gcdB = gcd( arrayB[i], gcdB );
		}

		if( !isDivide(arrayA, gcdB) ){

			answer = gcdB;

		}

		if( !isDivide(arrayB, gcdA) ){
			if( answer < gcdA )
				answer = gcdA;
		}


		return answer;
	}

	private int gcd( int max , int min ){

		if( min == 0 )
			return max;

		return gcd( min, max%min );
	}

	private boolean isDivide (int[] array, int num ){

		for( int n : array ){
			if( n%num == 0 )
				return true;
		}
		return false;

	}
}
