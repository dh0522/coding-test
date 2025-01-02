package coding_study.stkqdq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_28278 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		Stack<Integer> stk = new Stack<>();

		int n = Integer.parseInt(br.readLine());

		int demand;

		while( n-- > 0 ){
			st = new StringTokenizer(br.readLine());
			demand = Integer.parseInt(st.nextToken());

			switch ( demand ){
				case 1:
					stk.push(Integer.parseInt(st.nextToken()));
					break;
				case 2 :
					if (stk.isEmpty())
						sb.append(-1);
					else sb.append(stk.pop());
					sb.append("\n");
					break;
				case 3:
					sb.append( stk.size() ).append("\n");
					break;
				case 4:
					if (stk.isEmpty())
						sb.append(1);
					else sb.append(0);
					sb.append("\n");
					break;
				case 5:
					if (!stk.isEmpty())
						sb.append(stk.peek());
					else sb.append("-1");
					sb.append("\n");
					break;
			}
		}

		System.out.println(sb);

	}
}
