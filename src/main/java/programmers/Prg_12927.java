package programmers;
import java.util.*;
public class Prg_12927 {
    public static void main(String[] args) {

        Prg_12927 sol = new Prg_12927();

        System.out.println(sol.solution( new int[]{4,3,3}, 4) );
        System.out.println(sol.solution( new int[]{2,1,2}, 1) );
        System.out.println(sol.solution( new int[]{1,1}, 3) );

    }
    private long solution( int[] works , int n ){
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int sum=0;

        for( int i : works ){
            pq.add(i);
            sum+= i;
        }

        if( sum < n )
            return 0;

        while( n > 0 ){

            int max = pq.poll();
            n--;
            pq.add(max-1);


        }

        while( !pq.isEmpty() ){
            answer += Math.pow(pq.poll() , 2);
        }
        return answer;
    }
}