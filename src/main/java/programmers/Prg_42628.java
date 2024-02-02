package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class Prg_42628 {
    public static void main(String[] args) {

        Prg_42628 sol = new Prg_42628();

        String[] operations = { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" };
        int[] ans = sol.solution( operations );

        for(int i : ans )
            System.out.print(i+" ");
        System.out.println();


        String[] operations1 = { "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333" };
        int[] ans1= sol.solution( operations1 );

        for(int i : ans1 )
            System.out.print(i+" ");
        System.out.println();
    }

    private int[] solution(String[] operations){
        int[] answer = new int[2];

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> reversepq = new PriorityQueue<>(Collections.reverseOrder());


        for( String oper : operations ){

            String op = oper.split(" ")[0];
            int num = Integer.parseInt( oper.split(" ")[1] );

            if( op.equals("I") ){

                pq.add(num); // -5643 16
                reversepq.add(num);

            }else{ // op = D 일때

                if( pq.isEmpty() )
                    continue;

                if( num == 1 ){
                    pq.remove( reversepq.poll() );
                }else { // num == -1
                    pq.poll();
                }


            }
        }

        if( !pq.isEmpty() ){

            answer[0] = reversepq.peek();
            answer[1] = pq.peek();
        }

        return answer;
    }
}