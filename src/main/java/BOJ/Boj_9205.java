package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_9205 {

	static List<int[]> list;
	static int[] festival;
	static int[] now;
	static int n;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt( br.readLine() );

		while( t-- > 0 ){
			n = Integer.parseInt( br.readLine() );
			list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());

			now = new int[2];
			festival = new int[2];

			now[0] = Integer.parseInt(st.nextToken());
			now[1] = Integer.parseInt(st.nextToken());

			for( int i =0; i< n ; i++ ){
				st = new StringTokenizer(br.readLine());
				list.add( new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
			}

			st = new StringTokenizer(br.readLine());
			festival[0] = Integer.parseInt(st.nextToken());
			festival[1] = Integer.parseInt(st.nextToken());

			walk();

		}
	}
	public static void walk(){

		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[n]; // 편의점 방문 여부

		q.add(now);

		while( !q.isEmpty() ){

			int[] here = q.poll();
			int x = here[0];
			int y = here[1];

			int dis = Math.abs(festival[0]-x) + Math.abs(festival[1]-y);

			if( dis <= 1000 ){
				System.out.println("happy");
				return;
			}

			for( int i = 0; i< n; i++ ){
				if( !visited[i] ){
					int[] next = list.get(i);
					if( Math.abs(next[0]-x) + Math.abs(next[1]-y) <= 1000 ){

						q.add(next);
						visited[i] = true;
					}

				}
			}

		}

		System.out.println("sad");
		return;

	}
}














