package programmers.stack_queue;
import java.util.*;
public class Prg_12909 {
    public static void main(String[] args) {

        Prg_12909 sol = new Prg_12909();

        System.out.println(sol.solution("()()"));
        System.out.println(sol.solution("(())()"));
        System.out.println(sol.solution(")()("));
        System.out.println(sol.solution("(()("));

    }
    private boolean solution( String s ){
        boolean answer = true;

        Stack<Character> stk = new Stack<>();
        char[] chr = s.toCharArray();

        if( chr.length % 2 != 0 )
            return false;

        for( char ch  : chr ){

            if( ch == '(' ){
                stk.push(ch);
                continue;
            }

            if( stk.isEmpty() && ch == (')') )
                return false;

            if( !stk.isEmpty() && stk.peek() == '(' && ch == ')' ){
                stk.pop();
                continue;
            }


        }

        if( !stk.isEmpty() )
            answer = false;

        return answer;
    }
}