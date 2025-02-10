package coding_study.genmath;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_2903 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int row = (int)Math.pow(2,n) + 1;
		System.out.println(row*row);

	}
}
