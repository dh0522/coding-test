package coding_study.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Boj_18870 {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr= new int[n];
		Set<Integer> set = new TreeSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());

		for ( int i = 0; i < n; i ++ ){
			arr[i] = Integer.parseInt(st.nextToken());
			set.add(arr[i]);
		}

		List<Integer> list = new ArrayList<>(set);

		Map<Integer, Integer> map = new HashMap<>();
		for (int i =0; i < list.size(); i++ ){
			map.put( list.get(i) , i);
		}

		StringBuilder sb = new StringBuilder();
		for ( int i : arr ){
			sb.append( map.get(i) ).append(" ");
		}

		System.out.println(sb);

	}
}
