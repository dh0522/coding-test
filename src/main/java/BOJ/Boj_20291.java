package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Boj_20291 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<String, Integer> hm = new HashMap<>();

		for( int i =0; i < n ;i ++ ){
			String[] temp  = br.readLine().split("\\.");
			hm.put( temp[1] , hm.getOrDefault(temp[1] , 0) + 1 );
		}

		StringBuilder sb = new StringBuilder();

		List<String> keys = new ArrayList<>(hm.keySet());
		Collections.sort(keys);

		for ( String key : keys ){
			sb.append(key).append(" ").append(hm.get(key)).append("\n");
		}
		System.out.println(sb);


	}
}
