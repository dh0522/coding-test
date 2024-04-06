package SamsungSWTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_13458 {
	public static void main(String[] args) throws IOException {
		// n 개의 시험장 각 시험장마다 응시자수 = people[n]
		// 총감독관 감시가능 = b명 , 부감독관 감시가능 = c 명
		// 각 시험장에는 총감독관 오직 1명
		// 부감독관은 여러명 가능
		// 필요한 감독관의 최솟값은 ?
		// 일단 총감독관은 n명
		//
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] people = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for( int i =0 ;i <n; i++ ){
			people[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		long answer = n;

		for( int i = 0 ; i< n ;i++ ){

			people[i] -= b;
			if( people[i] <= 0)
				continue;
			if( people[i] % c == 0 ){
				answer += people[i]/c;
			}else{
				answer += people[i]/c + 1 ;
			}
		}

		System.out.println( answer );

	}
}
