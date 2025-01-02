package coding_study.stkqdq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_4949 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();


		while( true ){
			String now = br.readLine();
			if ( now.equals("."))
				break;

			sb.append( search(now) ).append("\n");
		}

		System.out.println(sb);

	}
	private static String search( String now ){

		Stack<Character> stk = new Stack<>();
		char c;

		now = now.replace(" ","");

		for ( int i = 0; i < now.length(); i++ ){

			c = now.charAt(i);

			if( c == '(' || c == '[')
				stk.push(c);

			else if( c == ')' ){

				if( !stk.isEmpty() && stk.peek() == '(' )
					stk.pop();
				else stk.push(c);

			}
			else if( c == ']' ) {

				if ( !stk.isEmpty() && stk.peek() == '[')
					stk.pop();
				else
					stk.push(c);
			}
		}


		if (stk.isEmpty())
			return "yes";
		return "no";
	}
}















