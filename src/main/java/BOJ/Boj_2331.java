package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_2331 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		HashMap<Integer, Integer> hm = new HashMap<>();
		hm.put( a, 1 );
		while( true ){

			int nextNum = 0;
			while( a > 0 ){
				int temp = a%10;
				nextNum += Math.pow( temp , p );
				a /= 10;
			}
			a = nextNum;

			hm.put( nextNum , hm.getOrDefault( nextNum , 0 ) +1 );

			if (hm.get(nextNum) == 3)
				break;

		}

		int answer = 0;
		for (int i : hm.keySet()){

			if ( hm.get(i) == 1 )
				answer++;
		}
		System.out.println(answer);

	}
}
