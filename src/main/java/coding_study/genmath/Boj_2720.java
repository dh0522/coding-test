package coding_study.genmath;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_2720 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int[] arr = { 25, 10, 5, 1 };
		int c ;

		for ( int i=0; i < t ; i ++ ){
			c = Integer.parseInt(br.readLine());

			for ( int j = 0; j < 4; j++ ){
				sb.append(c/arr[j]).append(" ");
				c %= arr[j];
			}

			sb.append("\n");
		}

		System.out.println(sb);
	}
}
