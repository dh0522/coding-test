package coding_study.stkqdq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj_2346 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		Deque<int[]> balloon = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer( br.readLine() );

		for ( int i =1; i <=n; i ++ ) {
			balloon.add( new int[]{i, Integer.parseInt(st.nextToken() )});
		}

		int[] now ;
		int next ;

		while ( !balloon.isEmpty() ){

			now = balloon.pollFirst();
			sb.append( now[0] ).append(" ");
			next = now[1];

			if ( balloon.isEmpty() )
				break;

			if ( next > 0 ){
				for (int i =0;i < next-1; i++ ){
					balloon.addLast( balloon.pollFirst() );
				}
			}
			else{
				for (int i = next; i < 0; i++ ){
					balloon.addFirst( balloon.pollLast() );
				}
			}

		}
		System.out.println(sb);

	}
}
