package programmers.brute_force;
import  java.util.*;
public class Prg_42840 {
    public static void main(String[] args) {

        Prg_42840 sol = new Prg_42840();

        int[] ans1 = sol.solution( new int[] {1,2,3,4,5} );
        int[] ans2 = sol.solution( new int[] {1,3,2,4,2} );

        for( int i : ans1 )
            System.out.print( i+" ");
        System.out.println();

        for( int i : ans2 )
            System.out.print( i+" ");
        System.out.println();
    }

    private int[] solution ( int[] answers ){

        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};

        int[] num = new int[3];

        for( int i =0 ; i< answers.length ; i++ ){

            if( answers[i] == one[i%5] )
                num[0]++;

            if( answers[i] == two[i%8] )
                num[1]++;

            if( answers[i] == three[i%10] )
                num[2]++;

        }

        int max = Math.max( num[0], Math.max( num[1], num[2] ) );

        List<Integer> list = new ArrayList<>();

        for( int i = 0 ; i < 3; i ++ ){
            if ( max == num[i] )
                list.add(i);
        }

        int[] answer = new int[ list.size() ];
        for( int i = 0 ; i< list.size(); i++ )
            answer[i] = list.get(i)+1;

        return answer;
    }
}
