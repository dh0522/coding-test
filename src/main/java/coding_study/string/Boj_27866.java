package coding_study.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_27866 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		int i = Integer.parseInt(br.readLine())-1;
		System.out.println(s.charAt(i));
	}
}
