package coding_study.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_11720 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String str = br.readLine();
		char[] ch = str.toCharArray();

		int sum = 0;
		for (char c : ch) {
			sum += Integer.parseInt( c+"" );
		}
		System.out.println(sum);
	}
}
