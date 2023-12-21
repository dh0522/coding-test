package programmers.hash;
import java.util.*;
public class Prg_42576 {
    public static void main(String[] args) {

        Prg_42576 sol = new Prg_42576();
        System.out.println( sol.solution ( new String[] { "leo", "kiki", "eden" }, new String[] { "eden", "kiki" }));
        System.out.println( sol.solution ( new String[] { "marina", "josipa", "nikola", "vinko", "filipa" }, new String[] { "josipa", "filipa", "marina", "nikola" }));
        System.out.println( sol.solution ( new String[] { "mislav", "stanko", "mislav", "ana" }, new String[] { "stanko", "ana", "mislav" }));
    }
    private String solution ( String[] participant , String[] completion ){
        String answer = "";
        HashMap< String , Integer > hm = new HashMap<>();

        for( String parti : participant ){
            hm.put( parti , hm.getOrDefault( parti, 0 )+1 );
        }

        for( String endman : completion ){

            if( hm.containsKey( endman ) ){
                hm.put( endman, hm.get(endman) - 1 );
            }
        }

        for( String notcom : participant ){

            if( hm.get( notcom ) == 1 ){
                answer = notcom;
                break;
            }
        }



        return answer;
    }
}