package coding_study.genmath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2745 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String N = st.nextToken();
		int B = Integer.parseInt(st.nextToken());

		if ( B == 10 ){
			System.out.println(N);
			return;
		}

		// b 진법 수 n 을 10진법으로 바꿔라
		// 36진법 으로 zzz
		long answer = 0;
		int num = 0;

		for ( int i=0; i < N.length(); i++ ){

			char ch = N.charAt( N.length() - i -1 );

			if( Character.isDigit( ch ) )
				num = Integer.parseInt( ch +"" );
			else
				num = ch - 'A' + 10;

			answer += num * (int)Math.pow( B , i );
		}
		System.out.println(answer);


	}
}
