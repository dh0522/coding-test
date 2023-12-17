package programmers.brute_force;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Prg_42839 {

    public static void main(String[] args) {

        Prg_42839 sol = new Prg_42839();

        System.out.println(sol.solution("17"));
        System.out.println(sol.solution("011"));


    }
    private boolean[] visited;
    private char[] chr;
    private Set<Integer> set;
    private int solution( String numbers ){

        chr = numbers.toCharArray();
        visited = new boolean[chr.length];
        set = new HashSet<>();

        search( "");

        return set.size();
    }
    private void search( String temp ){

        if( temp.length() != 0 && isPrime( Integer.parseInt(temp) ) ) {
            set.add(Integer.parseInt(temp));
        }

        for( int i = 0; i < chr.length; i++ ){
            if( !visited[i] ){

                visited[i] = true;
                search(temp + chr[i] );
                visited[i] = false;
            }

        }

    }

    private boolean isPrime( int num ){

        if( num < 2 )
            return false;
        else if( num == 2 )
            return true;
        else{

            for( int i = 2 ; i <= Math.sqrt(num)  ; i++ ){
                if( num % i == 0 )
                    return false;
            }
        }
        return true;
    }

}
