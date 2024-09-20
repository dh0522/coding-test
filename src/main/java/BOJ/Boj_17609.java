package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_17609 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		StringBuilder answer = new StringBuilder();

		while( t-- > 0 ){

			String now = br.readLine();

			StringBuilder sb = new StringBuilder(now);
			if( sb.toString().equals( sb.reverse().toString() ) ){
				answer.append(0+"\n");
				continue;
			}

			int left = 0;
			int right = now.length()-1;

			boolean check = false;

			while( left < right ){

				if( now.charAt(left) != now.charAt(right) ) {
					StringBuilder first = new StringBuilder(now).deleteCharAt(left);
					StringBuilder second = new StringBuilder(now).deleteCharAt(right);

					if( first.toString().equals( first.reverse().toString() ) || second.toString().equals( second.reverse().toString() )){
						answer.append(1+"\n");
						check = true;
					}
					break;
				}
				left ++;
				right--;
			}

			if(!check ) {
				answer.append(2 + "\n");
			}


		}

		System.out.println(answer.toString());
	}
}
