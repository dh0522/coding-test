package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj_1911 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int answer = 0;
		int last = 0;
		int[][] water = new int[n][2];

		for (int i=0; i < n; i ++ ){
			st = new StringTokenizer(br.readLine());

			water[i][0] = Integer.parseInt(st.nextToken());
			water[i][1] = Integer.parseInt(st.nextToken());

		}

		Arrays.sort(water, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1 , int[] o2 ){
				return o1[0]- o2[0];
			}
		});

		for( int i=0; i <n; i ++ ){
			int x = water[i][0];
			int y = water[i][1];

			if( y < last)
				continue;

			if ( i != 0 && x < last )
				x = last;


			int len = y-x;
			int count = len/l;
			if( len% l != 0 ){
				count++;
			}
			if( x +count*l > last )
				last = x + count*l;

			answer += count;

		}



		System.out.println(answer );
	}
}
