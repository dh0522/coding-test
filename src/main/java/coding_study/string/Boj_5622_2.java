package coding_study.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_5622_2 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		String[] arr = {null, null, "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };

		int answer = 0;
		char[] ch = str.toCharArray();

		for (char c : ch) {
			for (int i =2 ;i < arr.length; i++ ){
				if ( arr[i].indexOf(c) != -1 ){
					answer += i+1;
				}
			}
		}
		System.out.println(answer);
	}
}
