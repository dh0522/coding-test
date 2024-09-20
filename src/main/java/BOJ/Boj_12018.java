package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_12018 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] mileage = new int[n];

		for( int i=0; i < n; i ++ ){
			st = new StringTokenizer(br.readLine());
			int nowPeople = Integer.parseInt(st.nextToken());
			int limit = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());

			if( nowPeople < limit ){
				mileage[i] = 1;
				continue;
			}

			int[] temp = new int[nowPeople];
			for ( int k=0; k < nowPeople ; k++ ){
				temp[k] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort( temp );
			mileage[i] = temp[nowPeople-limit];
		}

		Arrays.sort( mileage );

		int idx = 0;

		for( int i =0; i < mileage.length; i++ ){
			if( mileage[i] > m )
				break;
			m -= mileage[i];
			idx++;
		}

		System.out.println( idx );
	}
}
