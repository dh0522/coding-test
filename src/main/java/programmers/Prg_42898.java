package programmers;
import  java.util.*;
public class Prg_42898 {
    public static void main(String[] args) {

        Prg_42898 sol = new Prg_42898();
        int[][] puddles = {{2,2}};
        System.out.println( sol.solution ( 4,3, puddles ) );

    }
    private int solution(int m, int n, int[][] puddles) {

        int[][] road = new int[n+1][m+1];

        for( int i =0 ; i< puddles.length ; i++ ) {

            int y = puddles[i][0] ;
            int x = puddles[i][1] ;
            road[x][y] = -1;

        }

        road[1][1] = 1;

        for( int i = 1 ;i <= n ; i++ ){
            for( int j = 1; j <= m ;j ++ ){

                if( i == 1 && j ==1 )
                    continue;

                if( road[i][j] == -1) {
                    road[i][j] = 0;
                    continue;
                }

                if( i == 1  )
                    road[i][j] = road[i][j-1]%1000000007;
                else if( j== 1 )
                    road[i][j] = road[i-1][j]%1000000007;

                else
                    road[i][j] = (road[i-1][j] + road[i][j-1])%1000000007;



            }
        }
        return road[n][m]%1000000007;
    }

}