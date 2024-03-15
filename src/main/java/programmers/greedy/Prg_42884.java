package programmers.greedy;

import java.util.Arrays;

public class Prg_42884 {
    public static void main(String[] args) {
        Prg_42884 sol = new Prg_42884();

        int[][] routes= {{-20,-15},{-14,-5},{-18,-13},{-5,-3}};

        System.out.println(sol.solution( routes ));

    }
    private int solution(int[][] routes ){
        int answer = 0;

        Arrays.sort( routes , (o1, o2) -> ( o1[1]- o2[1] ) );
        int min = 0 ;
        for( int i = 0 ;i < routes.length ;i++ ){

            if( i == 0 ){
                answer++;
                min = routes[i][1];
            }
            else {

                if (routes[i][0] > min) {
                    answer++;
                    min = routes[i][1];
                }
            }
        }
        return answer;

    }
}
