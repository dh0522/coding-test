package programmers;
import java.util.*;
public class Prg_12987 {
    public static void main(String[] args) {
        Prg_12987 sol = new Prg_12987();

        int[] A = {5,1,3,7};
        int[] B = {2,2,6,8};

        System.out.println(sol.solution(A,B));
    }
    private int solution( int[] A , int[] B ){

        int answer = 0 ;

        Arrays.sort(A);
        Arrays.sort(B);

        int idx = 0;

        for( int i = 0; i < A.length ; i++ ){

            if( A[idx] < B[i] ){
                answer++;
                idx++;
            }

        }


        return answer;
    }
}