package coding_study.sorting;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_25305{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < n; i++ ){
			pq.add(Integer.parseInt(st.nextToken()));
		}

		int answer = 0;
		while (k-- > 0){
			answer = pq.poll();
		}
		System.out.println(answer);
	}
}
