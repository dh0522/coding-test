package programmers;

import java.util.Stack;

public class Prg_131704 {
    public static void main(String[] args) {

        Prg_131704 sol = new Prg_131704();

        System.out.println(sol.solution( new int[] { 4, 3, 1, 2, 5 }));
        System.out.println(sol.solution( new int[] { 5, 4, 3, 2, 1 }));

    }
    private int solution( int[] order ){

        Stack<Integer> sub = new Stack<>();

        int idx = 0;
        int answer = 0;
        for( int i = 1; i<= order.length; i++ ){

            if( order[idx] != i ){

                sub.push(i);

            }else{
                answer++;
                idx++;
            }

            while( !sub.isEmpty() && sub.peek() == order[idx] ){

                sub.pop();
                answer++;
                idx++;

            }

        }
        return answer;

    }
}
