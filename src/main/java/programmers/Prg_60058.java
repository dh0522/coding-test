package programmers;
import java.util.Stack;
public class Prg_60058 {
	public static void main(String[] args) {

		Prg_60058 sol = new Prg_60058();

		String p1 = "()))((()";
		String p2 = "(()())()";
		String p3 = ")(";

		System.out.println(sol.solution( p1 ));
		System.out.println( sol.solution( p2 ));
		System.out.println( sol.solution( p3 ));

	}

	private String solution( String p ){

		StringBuilder answer = new StringBuilder();
		answer.append( recur(p) );

		return answer.toString();
	}
	private String recur( String p ){

		if( p.length() == 0 )
			return p;

		int idx = separate(p);
		String u = p.substring( 0, idx );
		String v = p.substring( idx  );

		if( balanced(u) ){
			return u + recur(v);
		}else{
			return "("+ recur(v) + ")" + change(u);
		}
	}

	private int separate( String p ){

		int left = 0;
		int right = 0;

		for( int i = 0; i < p.length(); i++ ){

			char now = p.charAt(i);

			if( now == '(' )
				left++;
			else
				right++;

			if( left == right ){

				return left + right;
			}

		}
		return 0;

	}
	private boolean balanced( String u ){
		Stack<Character> stk = new Stack<>();

		for( int i =0; i< u.length(); i++ ){
			if( i == 0 ){
				stk.push( u.charAt(0) );
				continue;
			}
			if( u.charAt(i) == ')' && stk.peek() == '(' ){
				stk.pop();
				continue;
			}
			stk.push( u.charAt(i) );
		}
		if( stk.isEmpty() )
			return true;
		return false;
	}

	private String change( String u ){

		if( u.length() < 2 )
			return u;

		StringBuilder sb = new StringBuilder();

		for( int i =1 ; i< u.length()-1; i++ ){
			if( u.charAt(i) =='(' ){
				sb.append(")");
			}else
				sb.append("(");
		}


		return sb.toString() ;
	}
}
