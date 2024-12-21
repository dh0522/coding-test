package coding_study.loop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10952 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int a, b;

		StringBuilder sb = new StringBuilder();
		while( true ){
			st = new StringTokenizer(br.readLine());

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			if( a == 0 && b == 0 )
				break;

			sb.append(a+b).append("\n");
		}
		System.out.println(sb);
	}
}
