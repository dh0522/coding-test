package programmers.exhaustive_search;

public class Prg_87946 {
    public static void main(String[] args) {

        Prg_87946 sol = new Prg_87946();

        System.out.println(sol.solution( 80 , new int[][] { {80,20},{50,40},{30,10} } ) );

    }

    private static boolean[] visited ;
    static int ans = 0 ;

    private int solution( int k , int[][] dungeons ){

        visited = new boolean[dungeons.length];
        dfs( k , dungeons , 0);
        return ans;

    }

    private void dfs( int k , int[][] dungeons , int num ){

        for( int i =0; i< dungeons.length ; i ++ ){

            if( !visited[i] && dungeons[i][0] <= k ){

                visited[i] = true;
                k = k - dungeons[i][1];
                dfs( k , dungeons , num+1 );
                visited[i] = false;
                k = k + dungeons[i][1];

            }

        }

        ans = Math.max( ans , num );
    }
}
