package programmers.greedy;
import java.util.*;
public class Prg_42862 {
    public static void main(String[] args) {

        Prg_42862 sol = new Prg_42862();
        System.out.println(sol.solution( 5, new int[] {2,4} , new int[] {1,3,5} ));
        System.out.println(sol.solution( 5, new int[] {2,4} , new int[] {3}  ));
        System.out.println(sol.solution( 3 , new int[]{3}, new int[]{1 } ) );

    }
    private int solution( int n , int[] lost , int[] reserve ){

        List<Integer> lostlst = new LinkedList<>();

        Arrays.sort( lost );
        Arrays.sort( reserve);

        for( int i : lost )
            lostlst.add(i);

        for( int i = 0 ; i< reserve.length; i++ ){
            if( lostlst.contains(reserve[i]) ){
                lostlst.remove(lostlst.indexOf(reserve[i]));
                reserve[i] = -1;
            }
        }

        for( int i =0 ;i < reserve.length ; i ++ ){

            int num = reserve[i];

            if( lostlst.contains(num-1) ){
                lostlst.remove( lostlst.indexOf(num-1) );
                continue;
            }
            else if( lostlst.contains(num+1) ){
                lostlst.remove( lostlst.indexOf(num+1) );
                continue;
            }

        }

        return ( n- lostlst.size() );
    }
}