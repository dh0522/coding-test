package coding_study.advanced1;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Boj_10988 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader( new InputStreamReader(System.in ));

		String str = br.readLine();
		StringBuilder rsb = new StringBuilder(str).reverse();

		if ( str.equals( rsb.toString()) )
			System.out.println(1);
		else
			System.out.println(0);

	}
}
