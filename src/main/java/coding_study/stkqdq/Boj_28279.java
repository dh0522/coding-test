package coding_study.stkqdq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_28279 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> dq = new LinkedList<>();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int demand;
		int num;

		while ( n-- > 0 ){
			st = new StringTokenizer(br.readLine());
			demand = Integer.parseInt(st.nextToken());

			switch ( demand ){
				case 1:
					dq.addFirst( Integer.parseInt(st.nextToken() ));
					break;
				case 2:
					dq.addLast( Integer.parseInt(st.nextToken()));
					break;
				case 3:
					if( dq.isEmpty() ){
						sb.append(-1);
					}else sb.append(dq.pollFirst());
					sb.append("\n");
					break;
				case 4:
					if( dq.isEmpty() ){
						sb.append(-1);
					}else sb.append(dq.pollLast());
					sb.append("\n");
					break;
				case 5:
					sb.append(dq.size()).append("\n");
					break;
				case 6:
					if ( dq.isEmpty() )
						sb.append(1);
					else sb.append(0);
					sb.append("\n");
					break;
				case 7:
					if (dq.isEmpty())
						sb.append(-1);
					else sb.append(dq.peekFirst());
					sb.append("\n");
					break;
				case 8:

					if (dq.isEmpty())
						sb.append(-1);
					else sb.append(dq.peekLast());
					sb.append("\n");
					break;
			}
		}

		System.out.println(sb);
	}
}
