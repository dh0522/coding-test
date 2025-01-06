package coding_study.stkqdq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_24511 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] type = new int[n];
		Deque<Integer> q = new ArrayDeque<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			type[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for( int i =0; i < n; i ++ ){
			if( type[i] == 0 )
				q.add(Integer.parseInt(st.nextToken()));

			else st.nextToken();

		}

		int m = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for( int i =0; i < m; i++ ){

			q.addFirst( Integer.parseInt(st.nextToken()) );
			sb.append(q.pollLast()).append(" ");
		}
		System.out.println(sb);

	}
}
