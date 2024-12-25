package coding_study.divmulprime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_2501 {
	private static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		getDivisor(n);
		if ( list.size() < k ){
			System.out.println(0);
			return;
		}

		Collections.sort(list);
		System.out.println(list.get(k-1));

	}
	private static void getDivisor( int n ){

		for ( int i = 1; i <= (int)Math.sqrt(n) ; i ++){
			if ( n % i == 0 ) {
				if ( i == n/i )
					list.add(i);
				else {
					list.add(i);
					list.add(n / i);
				}
			}
		}
	}
}
