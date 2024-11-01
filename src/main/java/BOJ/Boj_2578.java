package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_2578 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		boolean[][] arr = new boolean[5][5];
		HashMap<Integer, int[]> hm = new HashMap<>();

		for( int i=0 ; i < 5; i ++ ){
			st = new StringTokenizer(br.readLine());
			for( int j=0; j < 5; j ++ ) {

				int now = Integer.parseInt(st.nextToken());
				hm.put( now , new int[]{i,j} );
			}
		}

		List<Integer> list = new ArrayList<>();
		for( int i =0; i < 5; i++ ){
			 st= new StringTokenizer(br.readLine());
			 for ( int j  =0; j < 5; j++ )
				 list.add( Integer.parseInt(st.nextToken()) );
		}

		int count = 0;
		for(Integer now: list){
			count++;
			int[] idx = hm.get(now);
			arr[idx[0]][idx[1]] = true;

			if( count >= 10 ) {
				if (isBingo(arr)) {
					System.out.println(count);
					return;

				}
			}
		}
	}
	private static boolean isBingo( boolean[][] arr ){

		int num = 0;
		// 가로줄
		for( int i =0 ; i < 5; i ++ ){
			int cnt = 0;
			for( int j = 0; j < 5; j++ ){
				if( arr[i][j] )
					cnt++;
			}

			if( cnt == 5 )
				num++;
		}

		//세로줄
		for( int i =0 ; i < 5; i ++ ){
			int cnt = 0;
			for( int j = 0; j < 5; j++ ){
				if( arr[j][i] )
					cnt++;
			}

			if( cnt == 5 )
				num++;
		}

		int cnt = 0;
		for( int i =0 ; i < 5; i ++ ){
			if( arr[i][i] )
				cnt++;
		}

		if( cnt == 5 )
			num++;

		cnt = 0;
		for( int i =0 ; i < 5; i ++ ){
			if( arr[i][4-i] )
				cnt++;
		}
		if( cnt == 5 )
			num++;


		if( num >= 3 )
			return true;
		return false;
	}
}
