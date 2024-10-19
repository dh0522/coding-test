package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prg_17413 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		String s = br.readLine();

		StringBuilder sb = new StringBuilder();
		boolean no = false;
		StringBuilder temp = new StringBuilder();

		for ( int i=0; i < s.length(); i++ ){

			char ch = s.charAt(i);
			if ( i == s.length() -1 &&( ch != '>' || ch != ' ') ){
				temp.append(ch);
				sb.append( temp.reverse() );
				break;
			}


			if ( ch == ' ' ){
				sb.append( temp.reverse() ).append( ch );
				temp = new StringBuilder();
			}
			else if( ch == '<' ){
				no = true;
				sb.append( temp.reverse() ).append( ch );
				temp = new StringBuilder();
			}else if( ch == '>' ){

				sb.append( ch );
				no = false;
			}else if( no ){
				sb.append( ch );}
			else{
				temp.append(ch);
			}

		}



		System.out.println( sb );
	}
}
