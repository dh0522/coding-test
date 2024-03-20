package programmers;

public class Prg_12913 {
    public static void main(String[] args) {

        Prg_12913 sol = new Prg_12913();

        int[][] land = { {1,2,3,5}, {5,6,7,8}, {4,3,2,1} };


        System.out.println(sol.solution( land ) );

    }

    private int solution( int[][] land ){
        int answer = 0;
        int n = land.length;
        int[][] dp = new int[n][4];

        for( int i = 0 ; i < n ; i++ ){
            for( int j = 0 ; j < 4 ; j ++ ){

                if( i == 0 ){
                    dp[i][j] = land[i][j];
                    continue;
                }

                int num = 0 ;
                // j가 다를 때 -> 열이 다름
                for( int column = 0; column < 4; column ++ ){

                    if( column == j )
                        continue;
                    int now = land[i][j] + dp[i-1][column];
                    num = Math.max( num , now );
                }
                dp[i][j] = num;
            }


        }

        for( int i = 0 ; i< 4; i++ )
            answer = Math.max( answer , dp[n-1][i] );

        return answer;
    }
}