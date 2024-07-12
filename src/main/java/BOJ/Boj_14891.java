package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14891 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] arr = new String[8];

		for( int i = 0; i < 4; i++ ){
			arr[i] = br.readLine();
		}

		int k = Integer.parseInt( br.readLine() );

		StringTokenizer st;
		for( int i =0 ; i< k ; i++ ){
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken()) -1 ;
			int dir  = Integer.parseInt(st.nextToken());
			// order = 몇번째인지 dir = 방향
			change( arr , order , dir );

		}

		int answer = 0;

		int sum = 1;
		for( int i =0 ; i < 4; i++ ){
			if( arr[i].charAt(0) == '1' )
				answer += sum;
			sum *= 2;
		}

		System.out.println(answer);

	}
	private static void change( String[] arr , int order , int dir  ){

		int[] check = new int[4];
		check[order] = dir;
		/**
		 *  1: 시계  	-1: 반시계  	0: 안돌아
		 */

		for( int i = order+1; i < 4; i ++ ){
			if ( arr[i-1].charAt(2) == arr[i].charAt(6) )
				break;
			else
				check[i] = -check[i-1];
		}

		for( int i = order-1; i >= 0; i-- ){
			if( arr[i+1].charAt(6) == arr[i].charAt(2) ){
				break;
			}else{
				check[i] = -check[i+1];
			}

		}

		for( int i= 0; i < 4; i++ ){

			if( check[i] == 1 ){
				// 시계방향 회전
				arr[i] =  arr[i].charAt(7) + arr[i].substring(0,7);

			}else if( check[i] == -1 ){
				// 반시계 방향 회전
				arr[i] = arr[i].substring(1)+ arr[i].charAt(0);
			}

		}
	}
}

