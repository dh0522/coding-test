package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Boj_11724 {

    static boolean[] visited;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        list = new ArrayList[n+1];

        for (int i = 1; i <= n; i++)
            list[i] = new ArrayList<>();


        for (int i = 1; i <= m; i++) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        int answer = 0;

        for( int i =1 ;i <= n ; i++ ){

            if( !visited[i] ) {
                answer++;
                dfs(i);
            }
        }

        System.out.println(answer);
    }

    private static void dfs( int start ){

        if( visited[start] )
            return;
        visited[start]  = true;
        for( int i : list[start] ){
            if( !visited[i] ){
                dfs( i );
            }
        }

    }
}
