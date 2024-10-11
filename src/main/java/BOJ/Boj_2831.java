package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_2831 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> smallMan = new PriorityQueue<>();
		PriorityQueue<Integer> bigMan = new PriorityQueue<>();
		PriorityQueue<Integer> smallWoman = new PriorityQueue<>();
		PriorityQueue<Integer> bigWoman = new PriorityQueue<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0;i < n; i++ ){
			int now = Integer.parseInt(st.nextToken());
			if ( now < 0 ){
				smallMan.add( Math.abs(now) );
			}else{
				bigMan.add( now );
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++ ){
			int now = Integer.parseInt(st.nextToken());
			if ( now < 0 ){
				smallWoman.add( Math.abs(now) );
			}else{
				bigWoman.add( now );
			}
		}


		int answer = 0;

		while( !bigMan.isEmpty() && !smallWoman.isEmpty() ){

			int nowMan = bigMan.peek();
			int nowWoman = smallWoman.poll();
			if( nowMan < nowWoman ){
				answer++;
				bigMan.poll();
			}

		}

		while( !smallMan.isEmpty() && !bigWoman.isEmpty() ){

			int nowMan = smallMan.poll();
			int nowWoman = bigWoman.peek();
			if( nowWoman < nowMan ){
				answer++;
				bigWoman.poll();
			}

		}



		System.out.println(answer);

	}
}
