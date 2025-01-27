package coding_study.advanced2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import java.util.HashMap;
import java.util.List;

public class Boj_2108 {
	public static void main(String[] args) throws Exception {

		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		HashMap<Integer, Integer> hm = new HashMap<>();
		int sum = 0;

		while(n -- > 0){
			int num = Integer.parseInt(br.readLine());
			sum += num;
			list.add( num );
			hm.put( num, hm.getOrDefault(num, 0 ) + 1);
		}

		Collections.sort(list);

		int count = 0;
		List<Integer> forMax = new ArrayList<>();
		for ( Integer key: hm.keySet() ){
			if( count < hm.get(key) ){
				count = hm.get(key);
				forMax = new ArrayList<>();
				forMax.add(key);
			}else if( count == hm.get(key) ){
				forMax.add(key);
			}
		}

		Collections.sort(forMax);

		sb.append(Math.round((float)sum/list.size())).append("\n");
		sb.append(list.get(list.size()/2)).append("\n");
		if (forMax.size() == 1)
			sb.append(forMax.get(0)).append("\n");
		else {
			sb.append(forMax.get(1)).append("\n");
		}
		sb.append(list.get(list.size()-1) - list.get(0)).append("\n");

		System.out.println(sb);
	}
}
