package coding_study.oneArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_2562 {
	public static void main(String[] args)throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = Integer.MIN_VALUE;
		int idx = 0;
		int tmp;

		for (int i=1; i <= 9 ; i ++ ){

			tmp = Integer.parseInt(br.readLine());
			if ( tmp > max ){
				max = tmp;
				idx = i;
			}

		}
		System.out.println(max);
		System.out.println(idx);
	}
}
