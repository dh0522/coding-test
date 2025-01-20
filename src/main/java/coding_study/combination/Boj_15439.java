package coding_study.combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_15439 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		System.out.println(n*(n-1));
	}
}
