package programmers.brute_force;

public class Prg_86491 {
    public static void main(String[] args) {

        Prg_86491 sol = new Prg_86491();

        System.out.println(sol.solution(new int[][] { {60, 50},{30,70},{60,30},{80,40} }));
        System.out.println(sol.solution(new int[][] { {10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15} }));
    }

    private int solution( int[][] sizes ){

        int garo = Integer.MIN_VALUE;
        int sero = Integer.MIN_VALUE;

        for( int i= 0; i< sizes.length ; i ++ ){

            int max = Math.max( sizes[i][0] , sizes[i][1] );
            int min = Math.min( sizes[i][0] , sizes[i][1] );

            if( garo < max )
                garo = max;
            if( sero < min )
                sero = min;

        }

        return garo*sero;
    }
}