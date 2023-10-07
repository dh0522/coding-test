package BOJ.DP;
import java.util.*;
import java.io.*;
public class Boj_1149 {
    static int[][] home ;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        home = new int[n][3];

        int[] dp = new int[n+1];

        StringTokenizer st ;
        for( int i=0; i<n; i++ ){

            st = new StringTokenizer( br.readLine() );
            home[i][0] = Integer.parseInt(st.nextToken());
            home[i][1] = Integer.parseInt(st.nextToken());
            home[i][2] = Integer.parseInt(st.nextToken());

        }
        int ans = 0, j= 0;
        for( int i=0; i< n; i++ ){
          dp[i] = Math.min(home[i][0],home)
        }


    }
}
