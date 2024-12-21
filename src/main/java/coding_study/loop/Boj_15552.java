package coding_study.loop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15552 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int a , b;

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int i=0; i< t; i++ ){
			st= new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			sb.append(a+b).append("\n");
		}

		System.out.println(sb);
	}
}
