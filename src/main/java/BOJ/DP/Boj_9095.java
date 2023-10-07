package BOJ.DP;

import java.util.*;
import java.io.*;
public class Boj_9095 {
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[11];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for( int i=4; i< 11; i++ )
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];


        for( int i=0; i< n ;i++){
            int tmp = Integer.parseInt(br.readLine());
            System.out.println(dp[tmp]);
        }

    }
}