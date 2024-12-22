package coding_study.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_10809 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int[] arr = new int[26];
		Arrays.fill(arr,-1);

		for (int i=0; i <str.length(); i++ ){
			int idx = str.charAt(i)-97;
			if( arr[idx] != -1 )
				continue;
			arr[idx] = i;
		}

		StringBuilder sb = new StringBuilder();
		for (int i : arr) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
}
