package programmers.second;

public class Prg_17687 {
	public static void main(String[] args) {
		Prg_17687 sol = new Prg_17687();
		System.out.println(sol.solution( 2,4,2,1));
		System.out.println(sol.solution(16,16,2,1));
		System.out.println(sol.solution(16,16,2,2));
	}
	private static String solution( int n, int t, int m , int p ){

		StringBuilder all = new StringBuilder();
		all.append(0);
		int num = 1;

		while( all.length() <= m*t ){
			all.append(change( num , n ));
			num++;
		}

		StringBuilder answer = new StringBuilder();
		p--;
		for( int i =0; i < t; i++ ){
			answer.append( all.charAt(p) );
			p+=m;
		}

		return answer.toString();
	}
	private static String change( int num , int n ){


		StringBuilder sb = new StringBuilder();
		while( num != 0 ){
			int res = num%n;
			if( 10 <= res)
				sb.append( (char)(res -10 +'A') );
			else
				sb.append(res);
			num /= n;
		}


		return sb.reverse().toString();

	}
}
