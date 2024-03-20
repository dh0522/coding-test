package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2003 {
    public static void main(String[] args) throws IOException  {

        BufferedReader br = new BufferedReader( new InputStreamReader( System.in) );

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt( st.nextToken( ));
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];

        st = new StringTokenizer(br.readLine());

        for( int i = 0; i< n; i++ ){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        int start = 0;
        int end = 0;
        int sum = 0;

        while( end <= n ){

            if( sum >= m ){
                sum -= arr[start];
                start++;
            }
            else if( sum < m ){
                sum += arr[end];
                end++;
            }

            if( sum == m ){
                answer++;

            }
        }

        System.out.println( answer );
    }
}
