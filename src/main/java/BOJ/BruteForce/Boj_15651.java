package BOJ.BruteForce;
import java.io.*;
import java.util.*;
public class Boj_15651 {
    static int n,m;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m+1];

        nandm3(1, 0);
        System.out.println(sb);
    }
    public static void nandm3(int start, int index){
        if(index == m){
            for(int i= 0;i<m;i++)
                sb.append(arr[i]).append(" ");
            sb.append('\n');
            return;
        }

        for(int i =start; i <=n ;i++){

            arr[index] = i;// [1,]
            nandm3(start,index+1);
        }
    }
}
