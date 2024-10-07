package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj_2457 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;

		int n = Integer.parseInt(br.readLine());
		int[] month = {31,28,31,30,31,30,31,31,30,31,30,31};
		int[][] flower = new int[n][2];

		for (int i=0; i <n; i ++ ){
			 st = new StringTokenizer(br.readLine());
			 for (int j =0; j < 2; j ++ ){
				 int mon = Integer.parseInt(st.nextToken());
				 int day = Integer.parseInt(st.nextToken());

				 for (int k =0; k < mon-1; k++)
					 day += month[k];

				 flower[i][j] = day;
			 }
		}

		Arrays.sort( flower, new Comparator<>(){
			@Override
			public int compare( int[] o1 , int[] o2 ){
				if ( o1[0] == o2[0] )
					return o1[1] - o2[1];
				return o1[0]-o2[0];

			}
		});

		int answer = 0;


		int start = month[0]+month[1]+1;
		int finalEnd = 1;
		for (int i=0; i < 11; i ++)
			finalEnd += month[i];

		int end = 0;
		int idx = 0;

		while( start < finalEnd ){

			boolean isFront = false;
			for (int i= idx; i<n ;i++ ){

				if ( flower[i][0] > start )
					break;
				if( flower[i][0] <= start && end <= flower[i][1] ){
					end = flower[i][1];
					idx = i+1;
					isFront = true;
				}
			}

			if (isFront){
				answer++;
				start = end;
			}else break;
		}

		if ( end < finalEnd )
			System.out.println(0);
		else
			System.out.println(answer);


	}
}
