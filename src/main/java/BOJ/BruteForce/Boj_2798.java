package BOJ.BruteForce;
import java.util.*;
import java.io.*;
public class Boj_2798 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt( st.nextToken() );
        int m = Integer.parseInt( st.nextToken( ));
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine() );
        for( int i =0;i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for(int i =0; i<n-2;i++){
            for( int j = i+1; j<n-1; j++){
                for( int t = j+1; t<n; t++){

                    int tmp = arr[i]+arr[j]+arr[t];
                    if(max < tmp && tmp <= m)
                        max = tmp;

                }
            }
        }
        System.out.println(max);
    }
}
