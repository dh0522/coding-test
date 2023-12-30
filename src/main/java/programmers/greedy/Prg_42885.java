package programmers.greedy;
import java.util.*;
public class Prg_42885 {
    public static void main(String[] args) {

        Prg_42885 sol = new Prg_42885();

        System.out.println(sol.solution( new int[]{ 70, 50, 80, 50 },100));
        System.out.println(sol.solution( new int[]{ 70, 80, 50 }, 100 ));
    }

    private int solution( int[] people, int limit ){
        int answer = 0;
        Arrays.sort( people );

        int head = 0;
        int tail = people.length -1 ;

        while( head <= tail ){


            if( people[head] + people[tail] <= limit ){
                answer ++;
                head ++;
                tail--;
            }
            else{
                answer++;
                tail--;
            }

        }

        return answer;
    }
}