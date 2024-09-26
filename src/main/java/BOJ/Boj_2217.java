package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Boj_2217 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		List<Integer> list = new ArrayList<>();
		int[] weight = new int[n];
		for (int i=0; i <n; i++ ){
			weight[i] = Integer.parseInt(br.readLine());
			list.add( weight[i] );
		}

		Arrays.sort( weight );


		for (int i=0;i < n; i++ ){
			int now = weight[i];
			list.add( now*(n-i) );
		}
		Collections.sort( list );

		System.out.println(list.get(list.size()-1));
	}
}

