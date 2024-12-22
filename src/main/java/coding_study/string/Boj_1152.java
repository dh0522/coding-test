package coding_study.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_1152 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().strip();
		String[] strArr = str.split(" ");
		if (strArr[0] =="")
			System.out.println(0);
		else
			System.out.println(strArr.length);
	}
}
