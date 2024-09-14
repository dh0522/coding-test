package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Boj_1543 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		String fullWord = br.readLine();
		String findWord = br.readLine();

		StringBuilder sb = new StringBuilder(fullWord);
		int count = 0;
		while ( fullWord.contains(findWord) ){
			int idx = sb.indexOf( findWord );
			int length = findWord.length();

			sb.replace(idx,idx+length, " " );
			fullWord = sb.toString();
			count++;
		}
		System.out.println(count);
	}
}
