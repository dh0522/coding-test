package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_11866 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Deque<Integer> q = new LinkedList<>();
		for( int i = 1; i <= n ; i++ ){
			q.add( i );
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int idx = 0;

		while( !q.isEmpty() ){
			int now = q.pollFirst();
			if( q.isEmpty() ){
				sb.append(now+">");
				break;
			}
			idx++;
			if( idx == k ){
				sb.append(now+", ");
				idx = 0;
			}else{
				q.addLast(now);
			}
		}

		System.out.println(sb);
	}
}
