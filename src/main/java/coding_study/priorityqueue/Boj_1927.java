package coding_study.priorityqueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj_1927 {
	public static void main(String[] args) throws Exception {

		int num = 0;
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		while(n-- >0){
			num = Integer.parseInt(br.readLine());
				if( num == 0 ) {
					if (pq.isEmpty())
						sb.append(0).append("\n");
					else
						sb.append(pq.poll()).append("\n");
				}else if( num > 0 ){
					pq.add(num);

				}
		}
		System.out.println(sb);
	}
}
