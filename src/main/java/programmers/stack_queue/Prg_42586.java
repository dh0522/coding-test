package programmers.stack_queue;
import java.util.*;
public class Prg_42586 {
    public static void main(String[] args) {

        Prg_42586 sol = new Prg_42586();

        int[] ans1 = sol.solution( new int[]{93,30,55}, new int[]{ 1,30,5 });
        for( int i : ans1 )
            System.out.print(i+" ");
        System.out.println();
    }
    private int[] solution( int[] progresses , int[] speeds ){

        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < progresses.length; i++ ){

            int day = ( 100 - progresses[i] ) / speeds[i];

            if( ( 100 - progresses[i] ) % speeds[i] != 0 )
                day++;

            if( !q.isEmpty() && q.peek() < day ){

                list.add(q.size());
                q.clear();
            }
            q.add(day);
        }

        list.add(q.size());

        int[] answer = new int[list.size()];

        for(int i = 0; i < list.size() ; i++ ){
            answer[i] = list.get(i);
        }

        return answer;
    }
}