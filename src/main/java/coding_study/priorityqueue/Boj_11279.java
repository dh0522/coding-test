package coding_study.priorityqueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Boj_11279 {

	public static void main(String[] args) throws Exception {

		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int num = 0;

		while(n-- > 0){
			num = Integer.parseInt(br.readLine());
			if(num == 0){
				if( pq.isEmpty() )
					sb.append(0).append("\n");
				else sb.append(pq.poll()).append("\n");
			}
			else if( num > 0 )
				pq.add(num);
		}
		System.out.println(sb);
	}
}
