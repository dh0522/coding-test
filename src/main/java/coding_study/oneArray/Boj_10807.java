package coding_study.oneArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_10807 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Map<Integer,Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a ;

		for (int i =0; i< n; i++ ){

			a = Integer.parseInt(st.nextToken());
			map.put( a, map.getOrDefault(a, 0) +  1);
		}

		int v = Integer.parseInt(br.readLine());
		if( map.containsKey(v) ){
			System.out.println(map.get(v));
		}else
			System.out.println(0);
	}
}







