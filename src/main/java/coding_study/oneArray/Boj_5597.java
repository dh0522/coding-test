package coding_study.oneArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_5597 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[30];

		for (int i=0; i<28; i ++ ){
			arr[ Integer.parseInt(br.readLine())-1 ] = 1;
		}

		StringBuilder sb = new StringBuilder();
		for (int i=0; i< 30; i++ ){
			if (arr[i] == 0)
				sb.append(i+1).append("\n");
		}
		System.out.println(sb);
	}
}
