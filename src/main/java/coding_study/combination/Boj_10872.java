package coding_study.combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_10872 {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int answer = 1;
		while( n > 0){
			answer *= n--;
		}
		System.out.println(answer);
	}
}
