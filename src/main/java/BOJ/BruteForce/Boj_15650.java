package BOJ.BruteForce;
import java.util.*;
import java.io.*;
public class Boj_15650 {
    static int n,m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        nandm(1,0);

    }
    public static void nandm(int start, int index ) throws IOException {
        if( index == m ){
            for( int i = 0; i< m; i++)
                System.out.print(arr[i]+" ");
            System.out.println();
            return;
        }
        for( int i = start; i<= n; i++){
            arr[index] = i;
            nandm(i+1,index+1);
        }


    }
}
