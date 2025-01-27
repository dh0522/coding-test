package coding_study.advanced2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_20920 {
	public static void main(String[] args) throws Exception{

		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Map<String, Integer> hm = new HashMap<>();

		while (n -- > 0){
			String word = br.readLine();
			if ( word.length() < m )
				continue;
			hm.put(word, hm.getOrDefault(word, 0) + 1);
		}

		// 1. value로 정렬
		// 2. 해당 단어의 길이
		// 3. 알파벳 사전 순

		List<Map.Entry<String, Integer>> list = new ArrayList<>(hm.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				if ( o1.getValue() != o2.getValue() )
					return o2.getValue().compareTo(o1.getValue());
				if (o1.getKey().length() != o2.getKey().length())
					return o2.getKey().length() - o1.getKey().length();

				return o1.getKey().compareTo(o2.getKey());
			}
		});

		for (Map.Entry<String, Integer> entry : list) {
			sb.append(entry.getKey()).append("\n");
		}
		System.out.println(sb);


	}
}
