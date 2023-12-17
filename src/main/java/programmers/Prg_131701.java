package programmers;

import java.util.HashSet;
import java.util.Set;

public class Prg_131701 {
    public static void main(String[] args) {

        Prg_131701 sol = new Prg_131701();

        System.out.println( sol.solution( new int[]{7,9,1,1,4}) );
    }

    private int solution( int[] elements ){

        Set<Integer> set= new HashSet<>();

        for( int i = 1; i <= elements.length; i++ ){
            // i = 길이 ( 원소 갯수 )
            for( int index = 0; index < elements.length ; index++ ){

                int sum = 0;

                for( int j = index ; j < index + i ; j ++ ){

                    sum += elements[ j % elements.length ];

                }
                set.add(sum);

            }
        }
        return set.size();
    }
}
