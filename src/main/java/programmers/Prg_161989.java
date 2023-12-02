package programmers;

public class Prg_161989 {
    public static void main(String[] args) {

        Prg_161989 sol = new Prg_161989();
        System.out.println(sol.solution(8,4 , new int[]{2, 3, 6}));
        System.out.println(sol.solution(5,4 , new int[]{1,3}));
        System.out.println(sol.solution(4,1 , new int[]{1,2,3,4}));
    }

    private int solution( int n, int m , int[] section ){


        int roller = section[0];
        int answer = 1;

        for( int i = 1 ;i < section.length; i++ ){

            if( roller + m -1 < section[i] ){

                answer++;
                roller = section[i];

            }
        }
        return answer;
    }
}