package programmers;
import java.util.*;
public class Prg_138476 {
    public static void main(String[] args) {

        Prg_138476 sol = new Prg_138476();

        System.out.println(sol.solution(6, new int[]{ 1, 3, 2, 5, 4, 5, 2, 3 }));
        System.out.println(sol.solution(4, new int[]{ 1, 3, 2, 5, 4, 5, 2, 3 }));
        System.out.println(sol.solution(2, new int[]{ 1, 1, 1, 1, 2, 2, 2, 3 }));
    }
    private int solution( int k , int[] tangerine ){
        int answer = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();
        for( int i =0 ; i< tangerine.length; i++ )
            hm.put(tangerine[i]-1 , hm.getOrDefault(tangerine[i]-1, 0) +1);

        List<Integer> keyset = new ArrayList<>(hm.keySet());
        Collections.sort(keyset , (o1,o2)
                -> hm.get(o2).compareTo(hm.get(o1)));

        for( Integer key : keyset ){

            k = k - hm.get(key);
            answer++;
            if( k <= 0 )
                break;
        }

        return answer;
    }
}