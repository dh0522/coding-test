package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Prg_152996 {
    public static void main(String[] args) {
        Prg_152996 sol = new Prg_152996();
        System.out.println(sol.solution(new int[]{ 100,180,360,100,270 }));
    }
    private long solution( int[] weights ){

        long answer = 0;
        Arrays.sort(weights);

        Map<Double, Integer > map = new HashMap<>();
        for( int i = 0 ; i< weights.length; i++ ){

            int weight = weights[i];

            double one = weight*1.0;
            double two = (weight*1.0)/2.0;
            double three = (weight*2.0)/3.0;
            double four = (weight*3.0)/4.0;

            if( map.containsKey( one) )
                answer += map.get(one);
            if( map.containsKey(two) )
                answer += map.get(two);
            if( map.containsKey( three ) )
                answer += map.get(three);
            if( map.containsKey( four ) )
                answer += map.get(four);

            map.put( one , map.getOrDefault(one , 0)+1);
        }

        return answer;


    }
}
