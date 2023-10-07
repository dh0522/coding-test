package BOJ.DP;
import java.nio.Buffer;
import java.util.*;
import java.io.*;
public class Boj_1904 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
// 1001 1은 따로가 되지만 0110 -> 0은 따로가 불가능함.
        int[] dp = new int[n+1];


        dp[1] = 1; //1
        dp[2] = 2; // 00 11
        for( int i= 3; i<= n; i++){
            dp[i] = (dp[i-1] + dp[i-2] )%15746;
        }
        System.out.println(dp[n]);

    }
}
