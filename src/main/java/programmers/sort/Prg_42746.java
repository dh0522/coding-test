package programmers.sort;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
public class Prg_42746 {
    public static void main(String[] args) {

        Prg_42746 sol = new Prg_42746();

        System.out.println(sol.solution(new int[] { 6, 10, 2 }));
        System.out.println(sol.solution(new int[] { 3, 30, 34, 5, 9 }));
    }

    private String solution( int[] numbers ){

        List<Integer> list = new ArrayList<>();
        
        for( int i : numbers )
            list.add(i);

        Collections.sort(list , (a,b)->{
            String as = a + "";
            String bs = b + "";

            return -Integer.compare( Integer.parseInt(as+bs), Integer.parseInt(bs+as) );

        });

        StringBuilder sb = new StringBuilder();

        for(Integer i: list)
            sb.append(i);

        String answer = sb.toString();

        if( answer.charAt(0) == '0' )
            return "0";

        return answer;
    }
}
