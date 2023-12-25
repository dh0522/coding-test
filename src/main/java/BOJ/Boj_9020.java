package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_9020 {
    private static boolean[] prime;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        for( int i = 0; i < n ;i++ ){
            int input = Integer.parseInt( br.readLine() );

            for(int j = input/2 ; j>= 0; j-- ){
                if( isPrime(j) && isPrime(input-j) ) {
                    System.out.println(j + " " + (input - j));
                    break;
                }
            }

        }


    }
    public static boolean isPrime( int n ){
        // 10001개의 배열을 그냥 다 구해버려
        if( n==2 ) return true;

        for( int i = 2; i<= Math.sqrt(n); i++ ){
            if( n % i == 0 )
                return false;
        }

        return true;
    }
}
