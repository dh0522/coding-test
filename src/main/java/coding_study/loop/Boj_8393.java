package coding_study.loop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_8393 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine())+1;

		int sum = 0;
		while( n-- > 0 ){
			sum += n;
		}
		System.out.println(sum);
	}
}
