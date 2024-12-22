package coding_study.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2675 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for ( int i = 0; i < t ; i++ ){
			st = new StringTokenizer(br.readLine());


			int r = Integer.parseInt(st.nextToken());
			String str = st.nextToken();

			char[] chArr = str.toCharArray();
			for (char c : chArr) {
				sb.append( (c+"").repeat(r) );
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}
}
