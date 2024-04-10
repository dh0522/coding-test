package SamsungSWTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14888 {
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int n ;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader( System.in ));
		n = Integer.parseInt( br.readLine() );

		int[] number = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for( int i =0 ; i < n; i++ ){
			number[i] = Integer.parseInt(st.nextToken());
		}
		// 0 = + , 1 = - , 2 = * , 3 = /

		int[] sign = new int[4];
		st = new StringTokenizer(br.readLine());

		for( int i = 0 ;i < 4; i++ ){
			sign[i] = Integer.parseInt(st.nextToken());
		}


		search( number , sign , number[0], 1 );


		System.out.println(max);
		System.out.println(min);

	}

	// bruteforce dfs
	public static void search( int[] number , int[] sign , int sum, int depth ){

		if( depth == n ){

			max = Math.max( max , sum );
			min = Math.min( min , sum );

			return;

		}


		for( int j = 0; j < 4; j++ ){
			if( sign[j] == 0 )
				continue;
			sign[j]--;
			if( j == 0 ){
				search(number, sign, sum+number[depth] , depth+1 );
			}else if( j == 1 ){
				search(number, sign , sum-number[depth]  , depth+1 );
			}else if( j == 2 ){
				search(number, sign , sum*number[depth]  , depth+1 );
			}else{
				search(number, sign , sum/number[depth]  , depth+1 );
			}

			sign[j]++;

		}
	}
}
