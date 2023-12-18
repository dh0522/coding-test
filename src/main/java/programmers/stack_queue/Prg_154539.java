package programmers.stack_queue;

import java.util.Arrays;
import java.util.Stack;

public class Prg_154539 {
    public static void main(String[] args) {

        Prg_154539 sol = new Prg_154539();
        int[] ans1 = sol.solution( new int[] { 2,3,3,5 } );
        int[] ans2 = sol.solution( new int[] { 9,1,5,3,6,2 } );

        for( int i : ans1 )
            System.out.print(i+" ");
        System.out.println();

        for( int i : ans2 )
            System.out.print(i+" ");
        System.out.println();
    }

    private int[] solution (int[] numbers ){

        int[] answer = new int[numbers.length];
        Stack<Integer> stk =  new Stack<>();

        Arrays.fill( answer , -1 );

        for( int i =0 ;i < numbers.length ;i ++ ){

            while( !stk.isEmpty() && numbers[stk.peek()] < numbers[i] )
                answer[stk.pop()] = numbers[i];
            stk.push(i);

        }
        return answer;

    }
}
