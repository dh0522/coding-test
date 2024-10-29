package programmers;
import java.util.Stack;
public class Prg_76502 {
	public static void main(String[] args) {
		Prg_76502 sol = new Prg_76502();

		System.out.println(sol.solution("[](){}"));
	}
	private static int solution(String s){
		int answer = 0;

		char[] charr = s.toCharArray();
		for( int i =0 ;i < s.length(); i++ ){

			Stack<Character> stk = new Stack<>();

			for( int j = i; j < i + s.length() ; j++ ){
				char ch = charr[ j%s.length() ];


				if( stk.isEmpty() ){
					stk.push( ch );
				}else if( (stk.peek() == '(' && ch == ')') ||
					(stk.peek() == '[' && ch == ']' )||
					( stk.peek() == '{' && ch == '}' )){
					stk.pop();
				}else{
					stk.push( ch );
				}

			}

			if( stk.isEmpty() ){
				answer++;
			}
		}

		return answer;
	}
}
