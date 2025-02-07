package coding_study.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Boj_1427 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		List<Character> list = new ArrayList<>();

		for (char ch: str.toCharArray()){
			list.add(ch);
		}

		Collections.sort(list, Collections.reverseOrder());

		StringBuilder sb = new StringBuilder();
		for (char ch: list)
			sb.append(ch);

		System.out.println(sb);
	}
}
