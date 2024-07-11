package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_13458 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] room = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for( int i = 0 ; i < n ; i++ ){
			room[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		long answer = 0;
		for( int i =0; i< n; i++ ){

			room[i] -= b;
			answer++;

			if( room[i] <= 0 )
				continue;

			if( room[i]% c == 0 ){
				answer += room[i]/c;
			}else answer += room[i]/c +1;

		}

		System.out.println(answer);
	}
}
