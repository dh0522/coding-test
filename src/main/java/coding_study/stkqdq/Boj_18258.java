package coding_study.stkqdq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_18258 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st ;

		Deque<Integer> q = new LinkedList<>();

		int n = Integer.parseInt(br.readLine());
		String command;

		while( n-- > 0 ){
			st = new StringTokenizer(br.readLine());
			command = st.nextToken();

			switch ( command ){
				case "push":
					q.add( Integer.parseInt(st.nextToken()) );
					break;
				case "pop" :
					if ( q.isEmpty() )
						sb.append(-1);
					else sb.append(q.poll());
					sb.append("\n");
					break;
				case "size" :
					sb.append(q.size()).append("\n");
					break;
				case "empty":
					if (q.isEmpty())
						sb.append(1);
					else sb.append(0);
					sb.append("\n");
					break;
				case "front":
					if (q.isEmpty())
						sb.append(-1);
					else sb.append( q.peekFirst() );
					sb.append("\n");
					break;
				case "back":
					if (q.isEmpty())
						sb.append(-1);
					else sb.append(q.peekLast());
					sb.append("\n");
					break;
			}

		}
		System.out.println(sb);
	}
}
