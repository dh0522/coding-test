package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_15903 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		PriorityQueue<Long> list = new PriorityQueue<>();

		st = new StringTokenizer(br.readLine());
		for (int i=0; i <n; i++ )
			list.add( Long.parseLong(st.nextToken() ));

		while( m-- > 0 ){

			long newNum = list.poll() + list.poll();
			list.add(newNum);
			list.add(newNum);
		}

		long answer =0 ;

		while( !list.isEmpty() )
			answer += list.poll();

		System.out.println( answer );
	}
}
