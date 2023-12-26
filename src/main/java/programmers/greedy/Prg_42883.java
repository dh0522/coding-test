package programmers.greedy;

import java.util.Stack;

public class Prg_42883 {
    public static void main(String[] args) {

        Prg_42883 sol = new Prg_42883();

        System.out.println(sol.solution("1924", 2 ));
    }
    private String solution( String number ,int k ){

        StringBuilder sb = new StringBuilder();
        char[] ch = new char[number.length() - k ];

        Stack<Character> stk = new Stack<>();

        for( int i =0; i< number.length() ; i++ ){
            char temp = number.charAt(i);

            if( !stk.isEmpty() && stk.peek() < temp && k-->0 ){
                stk.pop();
            }

            stk.push(temp);
        }

        for( int i = 0 ; i < ch.length; i++ )
            sb.append( stk.get(i) );

        return sb.toString();
    }
}