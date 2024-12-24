package coding_study.twodimarray;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_10798 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] arr = new String[5];
		int maxLen = 0;

		for ( int i= 0 ; i < 5; i++ ){
			arr[i] = br.readLine();
			maxLen = Math.max(maxLen, arr[i].length());
		}

		char[][] chArr = new char[5][maxLen];
		for ( int i=0; i < 5; i++ ){
			chArr[i] = arr[i].toCharArray();
		}

		StringBuilder sb = new StringBuilder();
		for ( int i =0; i < maxLen ; i++ ){
			for (int j=0; j < 5 ; j ++ ){
				if ( arr[j].length() <= i )
					continue;
				sb.append(chArr[j][i]);
			}
		}

		System.out.println(sb);

	}
}
