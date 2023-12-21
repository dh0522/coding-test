package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Prg_132265 {
    public static void main(String[] args) {

        Prg_132265 sol = new Prg_132265();

        System.out.println(sol.solution( new int[]{ 1, 2, 1, 3, 1, 4, 1, 2 }));
        System.out.println(sol.solution( new int[]{  1, 2, 3, 1, 4  }));
    }

    private int solution( int[] topping ){

        int answer = 0;

        HashMap<Integer,Integer> hyung = new HashMap<>();
        Set<Integer> dongsang = new HashSet<>();

        for( int top : topping )
            hyung.put( top , hyung.getOrDefault( top , 0) + 1);

        for( int onetopping : topping ){

            hyung.put( onetopping , hyung.get( onetopping) -1 );
            if( hyung.get(onetopping) == 0 )
                hyung.remove(onetopping);

            dongsang.add( onetopping );

            if( hyung.size() == dongsang.size() )
                answer++;

        }
        return answer;

    }
}
