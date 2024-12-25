package coding_study.divmulprime;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_11653 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		int idx = 2;

		while( n != 1 ){

			if ( n % idx == 0 ) {
				sb.append(idx).append("\n");
				n /= idx;
			}
			else idx++;

		}

		System.out.println(sb);
	}
}
