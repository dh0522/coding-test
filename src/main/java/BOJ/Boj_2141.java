package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj_2141 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][2];

		long sum = 0;
		for (int i=0; i <n; i++ ){
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			sum += arr[i][1];
		}

		Arrays.sort( arr , new Comparator<int[]>() {
			@Override
			public int compare( int[] o1 , int[] o2 ){
				if( o1[0] == o2[0] )
					return o1[1]-o2[1];
				return o1[0]-o2[0];
			}
		});


		long answer = 0;
		for (int i=0; i < n; i ++ ){

			answer += arr[i][1];
			if ( (sum+1)/2 <= answer ){
				System.out.println( arr[i][0] );
				break;
			}

		}


	}
}
