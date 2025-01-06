package programmers.second;

import java.util.Arrays;
import java.util.Comparator;

public class Prg_17686 {
	public static void main(String[] args) {
		Prg_17686 sol = new Prg_17686();

		System.out.println(Arrays.toString( sol.solution( new String[]{ "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" })) );
	}
	private static String[] solution(String[] files ) {


		Arrays.sort( files , new Comparator<String>(){
			@Override
			public int compare( String o1, String o2 ){
				String head1 = "";
				String head2 = "";

				String number1 = "";
				String number2 = "";

				for(int i =0 ;i < o1.length(); i++ ){
					if( Character.isDigit(o1.charAt(i)) ){
						number1 = o1.substring(i);
						break;
					}

					head1 += o1.charAt(i)+"";
				}

				for(int i = 0; i < o2.length(); i ++){
					if( Character.isDigit(o2.charAt(i)) ){
						number2 = o2.substring(i);
						break;
					}
					head2 += o2.charAt(i)+"";
				}

				head1 = head1.toLowerCase();
				head2 = head2.toLowerCase();

				for( int i = 0; i < number1.length(); i++ ){
					if( !Character.isDigit( number1.charAt(i) ) ){
						number1 = number1.substring(0,i);
						break;
					}
				}
				for( int i=0; i < number2.length(); i++ ){
					if( !Character.isDigit(number2.charAt(i)) ){
						number2 = number2.substring(0,i);
						break;
					}
				}

				if( head1.equals(head2) ){
					return Integer.parseInt( number1 ) - Integer.parseInt( number2 );
				}
				else
					return head1.compareTo(head2);
			}
		});


		return files;
	}
}
