package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1459 {
	static long x,y;
	static int w,s;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		x  = Integer.parseInt(st.nextToken());
		y  = Integer.parseInt(st.nextToken());
		w  = Integer.parseInt(st.nextToken()); // 한 블록 가는데
		s  = Integer.parseInt(st.nextToken()); // 대각선 가ㅌ는데

		long answer = 0;
		if( 2*w <= s ){
			long count = x + y;
			answer = count*w;

		}
		else{ // ( 2*W > S )
			long max = Math.max( x,y );
			long min = Math.min( x,y );

			answer += min*s;

			if(  2*w > 2*s  ){
				long diff = max-min;
				answer += (diff/2)*2*s ;
				answer += (diff%2)*w;
			}else{
				answer += (max-min)*w;
			}
		}

		System.out.println(answer);
	}
}
