package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj_12933 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();


		char[] chArr = s.toCharArray();
		char[] duck = {'q','u','a','c','k'};
		boolean[] check = new boolean[s.length()];

		if( chArr[0] != 'q' || s.length() % 5 != 0 ) {
			System.out.println(-1);
			return;
		}

		int answer = 0;
		int pos = 0;
		for( int i =0; i < s.length(); i++ ){

			List<Character> list = new ArrayList<>();

			for( int j = i; j < s.length(); j++ ){
				if( !check[j] && chArr[j] == duck[pos] ){
					check[j] = true;
					pos = (pos+1)%5;
					list.add( chArr[j] );
				}
			}

			if ( !list.isEmpty() ){
				if( list.get( list.size()-1) != 'k' ){
					System.out.println(-1);
					return;
				}
				answer++;
			}


		}


		System.out.println(answer);

	}
}
