package coding_study.advanced1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_1157 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toUpperCase();
		char[] arr = str.toCharArray();

		int[] num = new int[26];

		int max = 0;
		boolean check = false;
		char answer = '?';
		for (char ch : arr ){
			num[ch-'A']++;
			if ( max < num[ch-'A'] ){
				answer = ch;
				max = num[ch-'A'];
				check = false;
			}else if( max == num[ch-'A'] ){
				check = true;
			}
		}

		if ( check )
			System.out.println("?");
		else
			System.out.println(answer);

	}
}
