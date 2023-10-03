package SamsungSWTest;

import java.util.*;
import java.io.*;
public class BOJ_14500 {
    static int n,m;
    static int[][] table;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int ans = 0;
    static int sum =0;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer( br.readLine() );

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        table = new int[n][m];
        visited = new boolean[n][m];



        for( int i =0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for( int j=0;j <m; j++){
                table[i][j] = Integer.parseInt( st.nextToken() );
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visited[i][j] = true;
                aroundmax(1,table[i][j],i,j);
                visited[i][j] = false;
            }
        }

        System.out.println(ans);

    }
    static void aroundmax(int num,int sum, int x, int y){
        // 현재 있는 곳 = table[x][y]
        if( num == 4 ) {
            if( ans < sum )
                ans = sum;
            return;
        }


        for( int i=0; i<4; i++){

            int nx = x + dx[i];
            int ny = y + dy[i];

            if( nx < 0 || ny < 0 || nx >=n || ny >= m)
                continue;



            if( !visited[nx][ny] ){

                if( num == 2 ){
                    visited[nx][ny] = true;
                    aroundmax(num+1,sum+table[nx][ny],x,y);
                    visited[nx][ny] = false;
                }
                visited[nx][ny] = true;
                aroundmax(num+1 ,sum+table[nx][ny], nx,ny);
                visited[nx][ny] = false;

            }



        }


    }

}
