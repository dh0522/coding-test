package coding_study.genmath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11005 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		while( N > 0 ){
			int res = N%B;
			if ( res < 10 )
				sb.append(res);
			else{
				sb.append( (char) ((N%B)+'A'-10) );
			}
			N /= B ;
		}

		System.out.println(sb.reverse());


	}
}
