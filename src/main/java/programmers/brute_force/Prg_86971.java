package programmers.brute_force;
import java.util.*;
public class Prg_86971 {
    public static void main(String[] args) {

        Prg_86971 sol = new Prg_86971();

        int[][] wires = {{ 1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9} };
        System.out.println(sol.solution( 9, wires ));
    }
    private int solution( int n , int[][] wires ){
        int answer = 100;

        for( int i = 0 ; i< wires.length ;i ++ ){

            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();

            int base1 = wires[i][0];
            int base2 = wires[i][1];

            set1.add( base1 );
            set2.add( base2 );

            while( set1.size() + set2.size() != n ){

                for( int j = 0; j < wires.length*2; j++ ){

                    int num = j% wires.length;

                    if( i == num )
                        continue;
                    if(set1.contains(wires[num][0]) || set1.contains( wires[num][1]) ) {

                        set1.add(wires[num][1]);
                        set1.add(wires[num][0]);

                    }else if(set2.contains(wires[num][0]) || set2.contains( wires[num][1]) ){
                        set2.add(wires[num][1]);
                        set2.add(wires[num][0]);
                    }

                }
            }
            answer = Math.min( answer, Math.abs( set1.size() - set2.size() ) ) ;

        }
        return answer;
    }
}