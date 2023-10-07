package BOJ.DP;
import java.util.*;
import java.io.*;
public class Boj_9461 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        long[] dp = new long[101];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for( int i= 4; i<=100; i++)
            dp[i] = dp[i-2] + dp[i-3];



        for(int i =0 ; i< t; i++){
            int n = Integer.parseInt( br.readLine() );
            System.out.println(dp[n]);
        }
    }
}
