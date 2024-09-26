package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_11399 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		List<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i=0;i < n; i++ ){
			list.add( Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);

		int answer = 0;
		int before = 0;
		for (int i=0; i<n; i++ ){

			if ( i == 0 ){
				answer = list.get(i);
				before = list.get(i);
				continue;
			}

			answer += list.get(i) + before;
			before = list.get(i)+before;
		}

		System.out.println(answer);

	}
}
