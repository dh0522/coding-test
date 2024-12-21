package coding_study.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2480 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		/** 1. 3개의 주사위의 값이 겹치는 게 있는지, 았다면 몇개인지
		 * 	2. 계산
		**/

		int[] arr = new int[7];
		for( int i =0; i < 3; i++ ){
			int num = Integer.parseInt(st.nextToken());
			arr[num]++;
		}

		int max = 0;

		for( int i=0; i < 7; i++ ){
			if( arr[i] == 0 )
				continue;
			if( arr[i] == 3 ){
				System.out.println(10000 + 1000*i);
				return;
			}
			else if( arr[i] == 2 ) {
				System.out.println(1000 + 100 * i);
				return;
			}

			if( arr[i] == 1 ){
				max = i;
			}
		}

		System.out.println(max*100);
	}
}
