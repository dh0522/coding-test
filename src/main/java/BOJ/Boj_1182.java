package BOJ;
import java.util.*;
import java.io.*;
public class Boj_1182 {
    static int n,s;
    static int[] numb;
    static boolean[] visited;
    static int ans=0,sum=0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt( st.nextToken());
        s = Integer.parseInt(st.nextToken());

        numb = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            numb[i] = Integer.parseInt(st.nextToken());
        }

        sum(0,0);

        if( s == 0 )
            ans-=1;

        System.out.println(ans);

    }
    public static void sum( int start , int sum ){

        if( start == n ){
            if( sum == s)
                ans++;
            return;
        }

        sum(start+1, sum +numb[start]);
        sum(start+1, sum);


    }
}
