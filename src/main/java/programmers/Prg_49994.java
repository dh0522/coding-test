package programmers;
import java.util.*;
public class Prg_49994 {
    public static void main(String[] args) {
        Prg_49994 sol = new Prg_49994();

        System.out.println(sol.solution("ULURRDLLU"));
        System.out.println(sol.solution("LULLLLLLU"));
    }
    private int solution ( String dirs ){

        char[] route  = dirs.toCharArray();
        return move( route ,0 , 0 );

    }
    private int move( char[] route , int x , int y ){

        HashSet<String> set = new HashSet<>();
        int nx = x ;
        int ny = y ;
        for( char dir : route ){

            switch( dir ){

                case 'L' :
                    nx -= 1;
                    break;
                case 'R' :
                    nx += 1;
                    break;
                case 'U' :
                    ny += 1;
                    break;
                case 'D' :
                    ny -= 1;
                    break;

            }

            if( nx > 5 || ny > 5 || nx < -5 || ny < -5 ){
                nx = x;
                ny = y;
                continue;
            }

            String str = String.valueOf(x) +String.valueOf(nx)
                    +String.valueOf(y) +String.valueOf(ny);
            String reverse = String.valueOf(nx) +String.valueOf(x)
                    +String.valueOf(ny) +String.valueOf(y);
            set.add(str);
            set.add(reverse);
            x = nx;
            y = ny;

        }

        return set.size()/2;

    }
}