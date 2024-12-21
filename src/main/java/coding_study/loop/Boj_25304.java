package coding_study.loop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_25304 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		int sum = 0;
		for( int i =0; i < n; i++ ){
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sum += a*b;
		}

		System.out.println(sum == x ? "Yes" : "No");

	}
}
