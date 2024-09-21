package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_1439 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		/**
		 *  문자열 S에 있는 모든 숫자를 전부 같게 만들려고 한다.
		 *  S에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것이다 0->1 , 1->0
		 *  00011000
		 */

		char[] ch = s.toCharArray();

		int zero = 0;
		int one = 0;

		char first = ch[0];
		if( first == '0' )
			zero++;
		else one++;

		for (int i=1; i < s.length(); i++ ){
			if ( first != ch[i] ){
				if( ch[i] == '0' ){
					first = '0';
					zero++;
				}else{
					first = '1';
					one++;
				}
			}
		}

		System.out.println(Math.min(zero,one));

	}

}
