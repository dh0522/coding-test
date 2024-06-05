package programmers;

public class Prg_12899 {
	public static void main(String[] args) {

		Prg_12899 sol = new Prg_12899();

		System.out.println(sol.solution( 10 ));
		System.out.println(sol.solution( 513 ));
	}

	private String solution( int n ){

		StringBuilder sb = new StringBuilder();

		while( n > 0 ){

			if( n % 3 == 0 ){
				sb.append(4);
				n = n/3 - 1;
			}
			else{
				sb.append( n%3 );
				n /= 3;
			}

		}

		return sb.reverse().toString();
	}
}
