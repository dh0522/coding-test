package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_2212 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> sensor = new ArrayList<>();

		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int now = Integer.parseInt(st.nextToken());
			sensor.add(now);
		}

		Collections.sort(sensor);

		List<Integer> gap = new ArrayList<>();
		for ( int i=0; i <  n-1  ; i ++){
			gap.add( sensor.get(i+1)-sensor.get(i) );
		}
		Collections.sort( gap );

		int answer =0;
		for (int i = 0 ; i < n-k ; i ++ ){
			answer += gap.get(i);
		}


		System.out.println(answer);
	}
}
