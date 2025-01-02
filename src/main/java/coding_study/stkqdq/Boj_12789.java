package coding_study.stkqdq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_12789 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 지금 서 있는 줄
		Queue<Integer> q = new LinkedList<>();
		for ( int i =0 ; i < n ; i++ )
			q.add( Integer.parseInt(st.nextToken()) );

		// 잉여 줄
		Stack<Integer> stk = new Stack<>();
		int start = 1;

		while ( start <= n ) {

			if ( stk.isEmpty() && q.isEmpty() )
				break;

			if (!q.isEmpty() && q.peek() == start) {
				q.poll();
				start ++;
			}
			else if ( !stk.isEmpty() && stk.peek() == start ){
				stk.pop();
				start ++;
			}else if ( !q.isEmpty() && !stk.isEmpty() && stk.peek() < q.peek() ){
				break;
			}
			else {
				stk.push( q.poll() );
			}
		}


		if ( stk.isEmpty() && q.isEmpty()  )
			System.out.println("Nice");
		else
			System.out.println("Sad");

	}
}
