package coding_study.genmath;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_2292 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		if ( n == 1 ){
			System.out.println(1);
			return;
		}


		int count = 1;
		int idx = 1;

		while( true ){
			count += 6*idx;
			idx++;
			if ( n <= count )
				break;
		}

		System.out.println(idx);
	}
}
