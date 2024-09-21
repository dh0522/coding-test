package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11501 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		while( t-- > 0 ) {

			int day = Integer.parseInt(br.readLine());
			int[] money = new int[day];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < day; i++) {
				money[i] = Integer.parseInt(st.nextToken());
			}

			long answer = 0;
			int max = money[day-1];
			for (int i= day-2; i >= 0 ; i-- ){
				if( max < money[i] ){
					max = money[i];
				}else{
					// max >= money[i]
					// 5 5 6
					answer += ( max- money[i] );
				}
			}
			sb.append( answer+"\n");

		}

		System.out.println(sb);
	}

}
