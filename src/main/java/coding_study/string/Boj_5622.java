package coding_study.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Boj_5622 {
	static int[] time ;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		time = new int[11];
		for (int i=1; i <= 10; i++ ) {
			time[i] = 2 + (i - 1);
		}


		int answer = 0;
		for (int i=0; i < str.length(); i ++ ){

			char ch = str.charAt(i);
			answer += searchTime(ch);
		}

		System.out.println(answer);
	}
	private static int searchTime( char ch ){

		if( ch == 'A' || ch == 'B' || ch == 'C' )
			return time[2];
		else if ( ch == 'D' || ch == 'E' || ch == 'F' )
			return time[3];
		else if ( ch == 'G' || ch == 'H' || ch == 'I' )
			return time[4];
		else if ( ch == 'J' || ch == 'K' || ch == 'L' )
			return time[5];
		else if ( ch == 'M' || ch == 'N' || ch == 'O' )
			return time[6];
		else if ( ch == 'P' || ch == 'Q' || ch == 'R' || ch == 'S' )
			return time[7];
		else if ( ch == 'T' || ch == 'U' || ch == 'V' )
			return time[8];
		else return time[9];

	}
}
