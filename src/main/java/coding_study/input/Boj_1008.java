package coding_study.input;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1008 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());

		double a = Integer.parseInt(st.nextToken());
		double b = Integer.parseInt(st.nextToken());
		System.out.println(a/b);


	}
}
