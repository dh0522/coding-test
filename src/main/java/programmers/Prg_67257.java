package programmers;




import java.util.ArrayList;

public class Prg_67257 {
	public static void main(String[] args) {

		Prg_67257 sol = new Prg_67257();
		System.out.println(sol.solution( "100-200*300-500+20" ));

	}

	static String[] operators = {"+,*,-","+,-,*","*,-,+","*,+,-","-,+,*","-,*,+"};
	static ArrayList<Long> list = new ArrayList<>();
	static ArrayList<Character> oper = new ArrayList<>();

	public static long solution(String expression){

		long answer = 0;

		StringBuilder sb = new StringBuilder();

		for( int i = 0 ; i < expression.length(); i++ ){
			char ch = expression.charAt(i);

			if( Character.isDigit( ch ) ) {
				sb.append( ch );

			}else {
				list.add( Long.parseLong ( sb.toString() ));
				oper.add( ch );
				sb = new StringBuilder();
			}
		}
		list.add( Long.parseLong ( sb.toString() ));



		for( int i = 0 ; i < 6; i++ ){
			String[] operator = operators[i].split(",");
			answer = Math.max( answer , calc( operator ) );
		}

		return answer;
	}
	private static long calc ( String[] operator ){

		ArrayList<Long> num = new ArrayList<>(list);
		ArrayList<Character> op = new ArrayList<>(oper);

		for( String want : operator ){

			for( int i = 0 ; i < op.size(); i ++ ) {

				String now = op.get(i)+"";

				if ( want.equals(now) ) {

					long first = num.get(i);
					long second = num.get(i+1);
					long newnum = twoCalc(first, second, want);

					num.remove(i + 1);
					num.remove(i);
					op.remove(i);

					num.add( i , newnum );
					i--;
				}

			}

		}

		return Math.abs( num.get(0) );

	}
	private static long twoCalc( long x , long y ,String oper ){

		if( oper.equals( "*" ) )
			return x*y;
		else if( oper.equals("+") )
			return x+y;
		else
			return x-y;

	}
}


















