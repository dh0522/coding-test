package programmers.second;

public class Prg_92335 {
	public static void main(String[] args) {
		Prg_92335 sol = new Prg_92335();

		System.out.println(sol.solution( 437674 , 3 ));
		System.out.println(sol.solution( 110011 , 10 ));
	}

	private static int solution( int n , int k ){
		int answer = 0;

		String number = "";
		if( k == 10 )
			number = String.valueOf(n);
		else
			number = change(n,k);

		String[] temp = number.split("0");

		for( String tmp : temp ){
			if( tmp.length() == 0 )
				continue;
			if( isPrime(Long.parseLong(tmp) ) )
				answer++;
		}

		return answer;
	}

	private static boolean isPrime( Long num ){

		if( num == 2 || num == 3 )
			return true;
		if( num == 1)
			return false;

		for( int i =2;i <= (int) Math.sqrt(num) ; i++ ){
			if( num%i == 0 )
				return false;
		}

		return true;
	}


	// n을 k진수로 변환 함수
	private static String change( int n , int k ){

		StringBuilder sb = new StringBuilder();

		while( n > 0 ){

			sb.append( n%k );
			n /= k;
		}

		return sb.reverse().toString();

	}
}





