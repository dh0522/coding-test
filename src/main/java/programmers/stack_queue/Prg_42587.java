package programmers.stack_queue;
import java.util.*;
public class Prg_42587 {
    public static void main(String[] args) {

        Prg_42587 sol = new Prg_42587();

        System.out.println( sol.solution( new int[] { 2, 1, 3, 2 },2));
        System.out.println( sol.solution( new int[] { 1, 1, 9, 1, 1, 1 },0));

    }
    private int solution ( int[] priorities , int location ){



        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for( int i : priorities ){
            list.add(i);
            q.add(i);
        }

        Collections.sort( list , Collections.reverseOrder() );
        int answer = 1;

        while( !q.isEmpty() ) {

            if (location < 0)
                location = q.size() - 1;

            if (q.peek() == list.get(0)) {

                if (location == 0)
                    break;

                location--;
                answer++;
                q.poll();
                list.remove(0);
                continue;
            }

            q.add(q.poll());
            location--;

        }
        return answer;
    }
}