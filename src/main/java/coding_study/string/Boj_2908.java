package coding_study.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2908 {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder one = new StringBuilder( st.nextToken()).reverse();
		StringBuilder two = new StringBuilder(st.nextToken()).reverse();

		System.out.println(Math.max( Integer.parseInt(one.toString()), Integer.parseInt(two.toString()) ));

	}
}
