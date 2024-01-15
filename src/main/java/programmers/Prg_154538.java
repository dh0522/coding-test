package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Prg_154538 {
    public static void main(String[] args) {

        Prg_154538 sol = new Prg_154538();

        System.out.println(sol.solution( 10, 40, 5));
        System.out.println(sol.solution( 10, 40, 30));
        System.out.println(sol.solution( 2, 5, 4 ));

    }
    private int solution( int x , int y , int n ){

        if( x == y )
            return 0;

        if( y%3 != 0 && y%2 != 0 && (y-x)%n != 0 )
            return -1;

        return search( x, y , n);

    }
    private int search(int x, int y, int n){

        Queue<Integer> q = new LinkedList<>();
        q.add( x );

        int[] dp = new int[1000001];

        while( ! q.isEmpty() ){

            int now = q.poll();

            int[] cal = new int[3];
            cal[0] = now + n;
            cal[1] = now * 2;
            cal[2] = now * 3;

            for( int i = 0 ; i< 3; i++ ){

                int next = cal[i];
                if( next > y )
                    continue;

                if( dp[next] == 0 || dp[next] > dp[now]+1 ){

                    dp[next] = dp[now]+1;
                    q.add( next );
                }

            }

        }

        return dp[y] != 0 ? dp[y] : -1;

    }
}
