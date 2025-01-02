package coding_study.stkqdq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_10773 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());

		Stack<Integer> stk = new Stack<>();
		int num;

		while ( k-- > 0 ){
			num = Integer.parseInt(br.readLine());

			if ( num == 0 )
				stk.pop();
			else stk.push(num);

		}

		int answer = 0;
		while ( !stk.isEmpty() ){
			answer += stk.pop();
		}

		System.out.println(answer);

	}
}
