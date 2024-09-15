package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Boj_2036 {
	// 26퍼에서 계속 틀림

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		List<Long> positive = new ArrayList<>();
		List<Long> negative = new ArrayList<>();

		int zeroCnt = 0;

		for (int i=0; i <n; i ++ ){
			long now = Long.parseLong( br.readLine());
			if (now == 0 )
				zeroCnt++;

			if( now < 0 )
				negative.add(now);

			else if( now > 0 )
				positive.add(now);
		}

		Collections.sort( positive ,Collections.reverseOrder());
		Collections.sort( negative );

		// { -6,-8, -3}
		/**
		 *  	음수가 1. 홀수개
		 * 			 2. 짝수개
		 */
		long answer = 0;


		if( negative.size()%2 == 1 && zeroCnt > 0  ){
			negative.remove( negative.size()-1 );
		}

		// 그럼 이제 negative는 다 짝수개 다.
		for (int i =0; i < negative.size(); i++ ){

			long first = negative.get(i);
			if ( (i+1) == negative.size() ){
				answer += first;
				continue;
			}
// 1+ 28  + 9
			long second = negative.get(i+1);

			answer += first*second;
			i++;
		}


		for (int i=0; i <positive.size(); i++ ){

			long first = positive.get(i);
			if( first == 1 || ( i +1 ) == positive.size() || positive.get(i+1) == 1 ){
				answer += first;
				continue;
			}

			long second = positive.get(i+1);
			answer += first*second;
			i++;
		}


		System.out.println( answer );
	}
}
