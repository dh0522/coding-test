package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10431 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int p = Integer.parseInt(br.readLine());

		int[] arr = new int[20];

		StringTokenizer st;
		for( int i =0 ; i < p ; i ++ ){

			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt( st.nextToken() );
			for( int j = 0 ;j < 20; j++ ){
				arr[j] = Integer.parseInt(st.nextToken());
			}

			int num = count(arr);
			System.out.println(order +" "+ num);
		}
	}
	static int count(int[] arr){

		int ans = 0;
		for( int i = 0 ; i < arr.length; i++ ){
			for (int j = 0; j < i; j ++ ){
				if( arr[j] > arr[i] ){
					ans++;
				}
			}

		}
		return ans;
	}
}
