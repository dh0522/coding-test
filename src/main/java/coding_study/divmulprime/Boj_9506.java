package coding_study.divmulprime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Boj_9506 {
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n ;

		while (true){

			n = Integer.parseInt(br.readLine());

			if ( n == -1 )
				break;

			isPerfect( n );
			sb.append("\n");

		}

		System.out.println(sb);
	}
	private static void isPerfect( int n ){

		List<Integer> list = new ArrayList<>();
		list.add( 1 );

		int sum = 1;

		for (int i= 2; i <= (int)Math.sqrt(n); i++ ){
			if ( n % i == 0 ) {
				if ( i == n/i ){
					sum += i;
					list.add( i );
					break;
				}

				list.add(i);
				list.add(n/i);

				sum += i;
				sum += n/i;
			}
		}

		if ( sum != n ){
			sb.append(n).append(" is NOT perfect.");
			return;
		}

		sb.append(n).append(" = ");
		Collections.sort(list);

		for ( int i = 0; i < list.size()-1; i++ )
			sb.append(list.get(i)).append(" + ");

		sb.append(list.get(list.size()-1));
	}
}
