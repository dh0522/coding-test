package coding_study.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_9086 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		String str = "";
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<t; i++ ){
			str = br.readLine();
			sb.append(str.charAt(0)).append(str.charAt(str.length()-1)).append("\n");
		}
		System.out.println(sb);
	}
}
