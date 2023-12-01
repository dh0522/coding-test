package programmers;
import java.util.*;
public class Prg_138477 {

    public static void main(String[] args) {

        Prg_138477 sol = new Prg_138477();

        int[] answer1 = sol.solution(3, new int[]{10, 100, 20, 150, 1, 100, 200});
        int[] answer2 = sol.solution(3, new int[]{0, 300, 40, 300, 20, 70, 150, 50, 500, 100});


        for( int i : answer1 )
            System.out.print(i+" ");
        System.out.println();

        for( int i : answer2 )
            System.out.print(i+" ");
        System.out.println();
    }

    private int[] solution(int k, int[] score){
        int[] answer = new int[score.length];
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for( int i = 0 ; i< score.length ; i++ ){


            q.add( score[i] );
            if( q.size() > k )
                q.poll();
            answer[i] = q.peek();

        }

        return answer;
    }
}