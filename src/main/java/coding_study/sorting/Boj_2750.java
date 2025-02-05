package coding_study.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj_2750 {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		while(n-- > 0){
			pq.add(Integer.parseInt(br.readLine()));
		}

		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty())
			sb.append(pq.poll()).append("\n");

		System.out.println(sb);
	}
}
