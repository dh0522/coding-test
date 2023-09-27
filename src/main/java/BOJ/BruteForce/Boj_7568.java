package BOJ.BruteForce;
import java.util.*;
import java.io.*;
public class Boj_7568 {
    public static void main(String[] args ) throws IOException{

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in ));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt( st.nextToken() );
        int[][] wheight = new int[n][2];
        int[] ans = new int[n];
        for( int i= 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            wheight[i][0] = Integer.parseInt( st.nextToken() );
            wheight[i][1] = Integer.parseInt( st.nextToken());

        }

        for( int i =0 ;i < n; i++){
            int num = 1;
            for(int j =0; j<n; j++){

                if( i == j )    continue;
                if( wheight[i][0] < wheight[j][0] && wheight[i][1] < wheight[j][1] )
                    num++;

            }

            ans[i] = num;

        }

        for(int i: ans)
            System.out.print(i+" ");
    }
}
