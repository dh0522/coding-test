package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_11000 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] time =new int[n][2];

		for (int i=0; i < n;i ++ ){
			st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort( time , new Comparator<int[]>() {

			@Override
			public int compare( int[] o1 , int[] o2 ){
				if( o1[0] == o2[0] )
					return o1[1]-o2[1];
				return o1[0]-o2[0];
			}
		});

		int answer = 1;

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add( time[0][1] );

		for (int i=1; i< n; i++ ){

			int endTime = pq.poll();

			if ( endTime <= time[i][0] ) {
				pq.add(time[i][1] );

			}
			else {
				pq.add(endTime);
				pq.add(time[i][1]);
				answer ++;
			}

		}
		System.out.println(answer);
	}
}
