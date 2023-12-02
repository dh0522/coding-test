package programmers;
import java.util.*;
public class Prg_135808 {
    public static void main(String[] args) {
        Prg_135808 sol = new Prg_135808();

        System.out.println(sol.solution(3,4,new int[]{1, 2, 3, 1, 2, 3, 1 }));
        System.out.println(sol.solution(4,3,new int[]{ 4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2 }));
    }
    private int solution( int k, int m , int[] score ){
        int answer = 0;

        Arrays.sort(score);

        for( int i = score.length ; i >= m; i -= m ){
            answer += score[ i - m ]*m;
        }

        return answer;
    }
}