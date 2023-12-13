package programmers;
import java.util.*;
public class Prg_12911 {
    public static void main(String[] args) {

        Prg_12911 sol = new Prg_12911();

        System.out.println(sol.solution(78));
        System.out.println(sol.solution(15));
    }

    private int solution(int n ){
        int answer = 0;

        String binn = Integer.toBinaryString(n);
        char[] chr = binn.toCharArray();
        int ns = 0;

        for( char ch : chr ){
            if( ch == '1' )
                ns++;
        }

        for( int i = n+1 ; i < 1000000; i ++ ){

            String temp = Integer.toBinaryString(i);
            int num = 0;
            char[] ch = temp.toCharArray();

            for( char c : ch ){
                if(c == '1' )
                    num++;
            }

            if( num == ns ){
                answer = i;
                break;
            }

        }

        return answer;
    }
}