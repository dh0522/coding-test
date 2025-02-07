package coding_study.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Boj_1181 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] strArr = new String[n];

		for (int i = 0; i < n; i++ ){
			strArr[i] = br.readLine();
		}

		Arrays.sort( strArr, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2){
				if ( o1.length() == o2.length() )
					return o1.compareTo(o2);
				return o1.length()-o2.length();
			}
		});

		StringBuilder sb = new StringBuilder();
		String exStr = "";
		for (String str: strArr) {
			if ( str.equals(exStr) )
				continue;
			sb.append(str).append("\n");
			exStr = str;
		}
		System.out.println(sb);
	}
}
