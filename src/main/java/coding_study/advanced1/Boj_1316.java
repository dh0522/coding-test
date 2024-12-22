package coding_study.advanced1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_1316 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] check;
		int answer = 0;
		for( int i=0; i < n; i++ ){
			String now = br.readLine();

			boolean poss = true;
			check = new int[26];
			char ex = 'a';

			for (int j=0; j <now.length(); j++ ){

				char ch = now.charAt(j);
				if( check[ch-'a'] == 0 ){
					ex = ch;
					check[ch-'a'] = 1;
				}else if( check[ch-'a'] == 1 && ex == ch ){
					continue;
				}else {
					poss = false;
					break;
				}
			}

			if (poss)
				answer++;

		}

		System.out.println(answer);
	}
}
