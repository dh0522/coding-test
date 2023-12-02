package programmers;
import java.util.*;
public class Prg_12921 {
    public static void main(String[] args) {
        Prg_12921 sol = new Prg_12921();
        System.out.println(sol.solution(10));
        System.out.println(sol.solution(5));
    }

    private int solution( int n ){
        int answer = 0;

        for( int i = 2; i <= n ; i++){

            if( isPrime(i) )
                answer++;
        }
        return answer;
    }
    private boolean isPrime(int num){

        if( num == 2 || num == 3 )
            return true;

        for( int i = 2 ; i < Math.sqrt(num) + 1 ;i ++ ){
            if( num% i == 0 )
                return false;
        }
        return true;
    }
}