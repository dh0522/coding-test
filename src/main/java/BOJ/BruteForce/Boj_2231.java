package BOJ.BruteForce;
import java.util.*;
import java.io.*;
public class Boj_2231 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt( st.nextToken());

        int divsum = 0 ;

        for( int j = (n/2) ; j < n; j++ ){
            int sum = 0;
            int tmp = j;
            sum += tmp ;

            while( tmp > 0){

                sum = sum + tmp%10;
                tmp /= 10;

            }

            if( sum == n ) {
                divsum = j;
                break;
            }



        }
        System.out.println( divsum );


    }
}
