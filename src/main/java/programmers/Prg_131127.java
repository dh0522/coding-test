package programmers;
import java.security.KeyStore;
import java.util.*;
public class Prg_131127 {
    public static void main(String[] args) {

        Prg_131127 sol = new Prg_131127();

        System.out.println(sol.solution( new String[] { "banana", "apple", "rice", "pork", "pot" },
                    new int[]{ 3, 2, 2, 2, 1 },
                    new String[]{ "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana" }));
    }

    private int solution( String[] want , int[] number , String[] discount ){

        HashMap<String , Integer> hm = new HashMap<>();

        for( int i =0 ; i< want.length ;i ++){
            hm.put(want[i], number[i]);
        }

        int answer = 0;
        int start = 0;

        while( start + 10 <= discount.length ){


            int all = number.length;

            HashMap<String , Integer> tmpmap = (HashMap<String, Integer>)hm.clone();

            for( int i = start; i < start + 10 ; i++ ){

                if( !tmpmap.containsKey( discount[i]) )
                    continue;
                tmpmap.put( discount[i] , tmpmap.get(discount[i]) -1 );
            }

            Iterator<String> iter = tmpmap.keySet().iterator();
            while( iter.hasNext() ){
                if( tmpmap.get(iter.next()).equals(0) )
                    all--;
            }

            if( all == 0 ){
                answer++;
            }

            start += 1;
        }
        return answer;
    }
}