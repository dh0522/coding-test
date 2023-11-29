package programmers;
import java.util.*;
public class Prg_142086 {
    public static void main(String[] args) {

        Prg_142086 sol = new Prg_142086();
        int[] sol1 = sol.solution("banana");
        int[] sol2 = sol.solution("foobar");

        for( int i : sol1 )
            System.out.print(i+" ");
        System.out.println();

        for( int i : sol2 )
            System.out.print(i+" ");
        System.out.println();
    }
    private int[] solution(String s ){
        int[] answer = new int[s.length()];
        Queue<Character> q = new LinkedList<>();

        for( int i =0 ; i< s.length(); i++ ){

            if( !q.contains( s.charAt(i) ) ){
                answer[i] = -1;
                q.add(s.charAt(i));
            }
            else{
                for( int j = 0; j< i ; j++ ){
                    if( s.charAt(j) == s.charAt(i) )
                        answer[i] = i-j;
                }
            }
        }

        return answer;
    }
}
