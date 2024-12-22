package coding_study.advanced1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_2444 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();


		for (int i = 1; i <= n; i++ ){
			for( int j = 0; j < n-i ; j++ ){
				sb.append(" ");

			}
			for (int j = 0; j < i*2 -1 ;  j++ )
				sb.append("*");
			sb.append("\n");
		}

		for (int i = n-1; i > 0 ; i-- ){
			for (int j =0; j < n-i ; j ++ )
				sb.append(" ");

			for (int j = 0; j < i*2 -1; j ++ )
				sb.append("*");
			sb.append("\n");
		}


		System.out.println(sb);
	}
}
