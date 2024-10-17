package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_20546 {
	public static void main(String[] args) throws Exception  {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[14];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for ( int i=0; i < 14; i++ ){
			arr[i] = Integer.parseInt(st.nextToken());
		}


		int jun = junhyun( arr , n );
		int seong = seongmin ( arr, n );


		if ( jun < seong ){
			System.out.println("TIMING");
		}else if( jun > seong ){
			System.out.println("BNP");
		}else
			System.out.println("SAMESAME");

	}
	private static int seongmin( int[] arr, int money ) {

		int stock = 0;

		for (int i = 3; i < 14; i++) {

			// 매수
			if ( arr[i-3] > arr[i-2] && arr[i - 2] > arr[i - 1] && arr[i - 1] > arr[i] &&  money / arr[i] != 0 ) {
				int newStock = money/arr[i];
				stock += newStock;
				money -= arr[i]*newStock;
			}

			// 매도
			else if (arr[i - 3] < arr[i - 2] && arr[i - 2] < arr[i - 1] && arr[i - 1] < arr[i] && stock!= 0 ) {
				money += stock * arr[i];
				stock = 0;
			}
		}

		if ( stock!= 0 ){
			money += stock*arr[13];
		}

		return money;
	}
	private static int junhyun( int[] arr, int money ){

		int junStock = 0;
		for ( int i=0; i < 13; i++ ){
			if ( money== 0 )
				break;

			int newStock = money/arr[i];
			junStock += newStock;
			money -= arr[i]*newStock;
		}

		money += junStock*arr[13] ;

		return money;

	}
}
