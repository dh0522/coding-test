package coding_study.input;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10869 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		sb.append(a+b).append("\n");
		sb.append(a-b).append("\n");
		sb.append(a*b).append("\n");
		sb.append(a/b).append("\n");
		sb.append(a%b).append("\n");
		System.out.println(sb);

	}
}
