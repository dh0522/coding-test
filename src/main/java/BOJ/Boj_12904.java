package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_12904 {
	static int answer = 0;
	// 1.시간초과  2. 2% 실패
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String t = br.readLine();

		StringBuilder sbT = new StringBuilder( t );

		while( s.length() < sbT.length() ){
			if( sbT.charAt(sbT.length()-1) == 'A' ){
				sbT.deleteCharAt( sbT.length() -1 );
			}else{
				sbT.deleteCharAt( sbT.length()-1);
				sbT.reverse();
			}
		}


		System.out.println( s.equals(sbT.toString()) ? 1 : 0 );
	}
}
