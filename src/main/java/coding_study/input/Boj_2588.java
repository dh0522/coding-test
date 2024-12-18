package coding_study.input;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_2588 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());

		int answer = 0;
		for( int i = 0; i < 3; i++ ){
			System.out.println(a*(b%10));
			answer += a*(b%10)*(int)Math.pow(10,i);
			b /= 10;
		}
		System.out.println(answer);
	}
}

