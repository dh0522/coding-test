package coding_study.divmulprime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_5086 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		int x,y;

		while( true ){
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			if ( x == 0 && y == 0 )
				break;

			if ( x < y && y%x == 0 )
				sb.append("factor").append("\n");
			else if( x > y && x%y == 0 )
				sb.append("multiple").append("\n");
			else sb.append("neither").append("\n");
		}

		System.out.println(sb);

	}
}
