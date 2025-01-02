package coding_study.stkqdq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_9012 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		Stack<Character> stk;
		char[] ch;

		while( t-- > 0 ){
			ch = br.readLine().toCharArray();
			stk = new Stack<>();
			for (char c : ch) {
				if ( c == '(' )
					stk.push(c);
				else if( !stk.isEmpty() && c == ')' ){
					if ( stk.peek() == '(' )
						stk.pop();
					else stk.push(c);
				}else stk.push(c);
			}

			if (stk.isEmpty())
				sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}

		System.out.println(sb);

	}
}
