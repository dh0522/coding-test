package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_17609 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		// 회문 = 0 , 유사회문 1 , 그 외는 2
		StringBuilder sb = new StringBuilder();
		while ( t-- > 0) {

			String now = br.readLine();

			StringBuilder temp = new StringBuilder(now);

			if( now.equals( temp .reverse().toString()) ) {
				sb.append(0+"\n");
				continue;
			}

			int left = 0;
			int right = now.length() - 1;
			boolean poss = false;

			while ( left < right ){
				if( now.charAt(left) != now.charAt(right) ){

					StringBuilder nowsb = new StringBuilder(now).deleteCharAt(left);
					StringBuilder reverse = new StringBuilder(now).deleteCharAt(right);


					if( nowsb.toString().equals( nowsb.reverse().toString()) || reverse.toString().equals( reverse.reverse().toString() ) ){
						sb.append(1+"\n");
						poss = true;
					}
					break;
				}

				left ++;
				right--;
			}

			if( !poss )
				sb.append( 2+"\n" );

		}
		System.out.println(sb.toString());
	}
}
