package programmers;
import java.util.*;
public class Prg_160586 {
    public static void main(String[] args) {

        Prg_160586 sol = new Prg_160586();

        int[] ans1 = sol.solution(new String[]{"ABACD", "BCEFD"} , new String[]{"ABCD","AABB"} );
        for( int i : ans1 )
            System.out.print(i+" ");
        System.out.println();

        int[] ans2 = sol.solution(new String[]{"AA"} , new String[]{"B"} );
        for( int i : ans2 )
            System.out.print(i+" ");
        System.out.println();

        int[] ans3 = sol.solution(new String[]{"AGZ","BSSS"} , new String[]{"ASA","BGZ"} );
        for( int i : ans3 )
            System.out.print(i+" ");
        System.out.println();
    }

    private int[] solution(String[] keymap, String[] targets){
        int[] answer = new int[targets.length];

        HashMap<Character, Integer> hm = new HashMap<>();

        for( String str : keymap ){

            char[] chr = str.toCharArray();
            for(int i =0; i< chr.length; i ++ ){
                int num = 0;
                if( hm.containsKey( chr[i] ) ){
                    num = Math.min( hm.get(chr[i]), i+1 );
                    hm.put(chr[i],num);
                }
                else
                    hm.put( chr[i], i +1 );
            }
        }

        for( int i =0 ;i < targets.length ;i ++ ){
            int n = 0;
            char[] chr = targets[i].toCharArray();
            for( char ch : chr ){
                if( !hm.containsKey(ch) ){
                    n = -1;
                    break;
                }
                n += hm.get(ch);
            }
            answer[i] = n;

        }

        return answer;
    }
}
