package coding_study.stkqdq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_11866 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		sb.append("<");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		// 1, 2, 3, 4, 5, 6, 7
		// 순서대로 k번째 사람을 제거한다.
		// 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
		// 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
		// 원에서 제거되는 사람들의 순서를 요세푸스 순열이라고 한다.

		Queue<Integer> q = new LinkedList<>();
		for ( int i = 1; i <= n; i++ )
			q.add( i );

		while( !q.isEmpty() ){
			for ( int i = 0; i < k-1 ; i++ ){
				q.add( q.poll() );
			}

			sb.append(q.poll());
			if ( !q.isEmpty() )
				sb.append(", ");
		}

		sb.append(">");
		System.out.println(sb);
	}
}
