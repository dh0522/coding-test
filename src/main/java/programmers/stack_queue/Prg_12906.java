package programmers.stack_queue;

import programmers.Prg_12949;

import java.util.Stack;

public class Prg_12906 {
    public static void main(String[] args) {

        Prg_12906 sol = new Prg_12906();

        int[] ans1 = sol.solution(new int[] { 1,1,3,3,0,1,1 });
        int[] ans2 = sol.solution(new int[] { 4,4,4,3,3 });

        for( int i : ans1 )
            System.out.print(i+" ");
        System.out.println();

        for( int i : ans2 )
            System.out.print(i+" ");
        System.out.println();
    }

    private int[] solution( int[] arr ){

        Stack<Integer> stk = new Stack<>();

        for( int i : arr ){
            if( stk.isEmpty() || stk.peek() != i )
                stk.add(i);
        }

        int[] ans = new int[stk.size()];

        for( int i = ans.length -1 ; i >= 0 ; i-- ){
            ans[i] = stk.pop();
        }

        return ans;
    }
}
