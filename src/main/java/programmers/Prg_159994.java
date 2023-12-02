package programmers;
import java.util.*;
public class Prg_159994 {
    public static void main(String[] args) {
        Prg_159994 sol = new Prg_159994();

        System.out.println(sol.solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"} ,
                new String[]{"i", "want", "to", "drink", "water"} ));
        System.out.println(sol.solution(new String[]{"i", "water" ,"drink"}, new String[]{"want", "to"} ,
                new String[]{"i", "want", "to", "drink", "water"} ));
    }
    private String solution (String[] cards1 , String[] cards2 , String[] goal ){


        Queue<String> q1 = new LinkedList<>();
        for( int i = 0 ; i < cards1.length; i++)
            q1.add(cards1[i]);

        Queue<String> q2 = new LinkedList<>();
        for( int i =0; i< cards2.length ;i++ )
            q2.add(cards2[i]);

        Queue<String> goalq = new LinkedList<>();
        for( int i =0 ;i < goal.length; i++ )
            goalq.add( goal[i] );

        while( !goalq.isEmpty() ){

            if( goalq.peek().equals( q1.peek() ) ){
                goalq.poll();
                q1.poll();
            }else if( goalq.peek().equals( q2.peek() ) ){
                goalq.poll();
                q2.poll();
            }else
                return "No";

        }

        return "Yes";
    }
}