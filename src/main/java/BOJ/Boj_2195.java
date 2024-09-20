package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_2195 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String p = br.readLine();

		int count = 0;
		StringBuilder remove = new StringBuilder( p );

		while( remove.length() !=  0 ){

			int idx = 1;
			for ( int j=1; j < remove.length()+1 ; j++ ){
				String temp = remove.substring( 0, j );
				if ( s.contains( temp ) ){

					idx = j;
				}else{
					break;
				}
			}

			count++;
			remove.delete(0,idx);

		}

		System.out.println(count);
	}
}
