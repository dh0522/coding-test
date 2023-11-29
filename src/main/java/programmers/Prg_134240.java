package programmers;
import java.util.*;
public class Prg_134240 {
    public static void main(String[] args) {

        Prg_134240 sol = new Prg_134240();

        System.out.println(sol.solution(new int[] {1,3,4,6}));
        System.out.println(sol.solution(new int[] {1,7,1,2}));
    }
    private String solution( int[] food ){
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for( int i =1 ;i < food.length; i++){
            String tmp = "";
            for( int j = 0 ; j< food[i]/2; j++ ){
                answer += i;
                sb.append(i);
            }
        }
        answer += 0;
        answer += sb.reverse().toString();


        return answer;
    }
}
