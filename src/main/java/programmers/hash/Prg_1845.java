package programmers.hash;

import programmers.dfsbfs.Prg_1844;

import java.util.HashMap;

public class Prg_1845 {
    public static void main(String[] args) {

        Prg_1845 sol = new Prg_1845();
        System.out.println(sol.solution( new int[]{3,1,2,3}));
    }

    private int solution( int[] nums ){

            int answer = 0;
            int mymon = nums.length /2 ;
            HashMap< Integer,Integer> hm = new HashMap<>();

            for( int kind : nums )
                hm.put( kind , hm.getOrDefault( kind , 0 ) +1 );

            if( mymon <= hm.size() )
                answer = mymon;
            else
                answer = hm.size();


            return answer;
        }
    }