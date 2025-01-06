package coding_study.priorityqueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Boj_11286 {
	public static void main(String[] args) throws Exception  {

		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>( new Comparator<Integer>(){
			@Override
			public int compare( Integer o1, Integer o2 ){
				if( Math.abs(o1) == Math.abs(o2) )
					return o1.compareTo(o2);
				return Math.abs(o1)-Math.abs(o2) ;
			}
		});
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int num = 0;
		while( n-- > 0 ){
			num = Integer.parseInt(br.readLine());
			if( num == 0 ){
				if ( pq.isEmpty())
					sb.append(0).append("\n");
				else sb.append(pq.poll()).append("\n");
			}else
				pq.add(num);
		}
		System.out.println(sb);
	}
}
