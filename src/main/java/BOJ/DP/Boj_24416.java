package BOJ.DP;
import java.nio.Buffer;
import java.util.*;
import java.io.*;
public class Boj_24416 {
    static int fibn = 0 ;
    static int fibonaccin = 0;
    static int[] dp ;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt( br.readLine() );
        dp = new int[n+1];

        fib(n);
        fibonacci(n);
        System.out.println(fibn+" "+fibonaccin);

    }
    static int fib(int n){


        if( n == 1 || n == 2 ) {
            fibn++;
            return 1;
        }

        return (fib(n - 1) + fib(n - 2));

    }
    static int fibonacci( int n ){

        if( n == 1 || n== 2)
            return 1;

        for( int i= 3; i<= n; i++){
            fibonaccin++;
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
