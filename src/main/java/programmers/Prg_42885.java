package programmers;
import java.util.*;
public class Prg_42885 {
    public static void main(String[] args) {

        Prg_42885 sol = new Prg_42885();

        System.out.println(sol.solution(new int[]{70, 50, 80, 50 }, 100));
        System.out.println(sol.solution(new int[]{70,80,50 }, 100));
    }

    private int solution(int[] people, int limit){


        int answer = 0;
        Arrays.sort( people );

        if( people[0] + people[1] > limit )
            return people.length;

        Deque<Integer> dq = new ArrayDeque<>();

        for( int i : people )
            dq.addLast(i);

        while( !dq.isEmpty() ){

            if( dq.size() == 1 ){
                answer++;
                break;
            }

            if( dq.peekFirst() + dq.peekLast() <= limit ){

                dq.remove();
                dq.removeLast();
                answer++;

            }else {

                dq.removeLast();
                answer++;
            }

        }

        return answer;
    }
}
