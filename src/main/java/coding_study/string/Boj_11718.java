package coding_study.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_11718 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str;
		while( (str = br.readLine()) != null ){
			sb.append( str ).append("\n");
		}

		System.out.println(sb);


	}
}
