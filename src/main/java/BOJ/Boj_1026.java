package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_1026 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		List<Integer> list = new ArrayList<>();

		List<Integer> list2 = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i =0; i <n; i++ )
			list.add(Integer.parseInt(st.nextToken()));

		st = new StringTokenizer(br.readLine());
		for (int i=0; i < n ; i++ )
			list2.add(Integer.parseInt(st.nextToken()));

		Collections.sort(list);
		Collections.sort( list2, Collections.reverseOrder() );

		int answer = 0;
		for (int i=0; i < n; i ++ ){
			answer += list.get(i)*list2.get(i);
		}
		System.out.println(answer);
	}
}
