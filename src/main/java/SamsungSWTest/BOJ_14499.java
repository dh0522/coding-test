package SamsungSWTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14499 {
    // 동 1 , 서 2 , 북 3 , 남 4

    static int n, m;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int[] dice = new int[6];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j ++ ){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        // 이동한 칸에 쓰여있는 수 = 0 -> 주사위의 바닥면에 쓰여있는 수가 칸에 복사된다.
        // 이동한 칸이 0이 아닌 경우 -> 칸에 쓰여있는 수가 주사위의 바닥면에 복사되고 칸은 0이된다.
        // 주사위가 이동했을때마다 상단에 쓰여 있는 값을 출력해라

        for (int i = 0; i < k; i++) {

            int dir = Integer.parseInt(st.nextToken());

            int nx = x + dx[dir-1];
            int ny = y + dy[dir-1];

            if( nx < 0 || ny < 0 || nx >= n || ny >= m )
                continue;

            godir( dir );

            if( map[nx][ny] == 0 ){
                map[nx][ny] = dice[1];
            }else {
                dice[1] = map[nx][ny];
                map[nx][ny] = 0;
            }
            System.out.println( dice[0] );

            x = nx;
            y = ny;

        }

    }
    public static void godir( int dir ){
        // 위 = 0 아래 = 1 앞=2 뒤=3 왼=4 오=5
        if( dir == 1 ){

            int temp = dice[1];
            dice[1] = dice[5];
            dice[5] = dice[0];
            dice[0] = dice[4];
            dice[4] = temp;

        }else if( dir == 2 ){

            int temp = dice[1];
            dice[1] = dice[4];
            dice[4] = dice[0];
            dice[0] = dice[5];
            dice[5] = temp;

        }else if( dir == 3){

            int temp = dice[1];
            dice[1] = dice[3];
            dice[3] = dice[0];
            dice[0] = dice[2];
            dice[2] = temp;

        }else if ( dir == 4 ) {

            int temp = dice[1];
            dice[1] = dice[2];
            dice[2] = dice[0];
            dice[0] = dice[3];
            dice[3] = temp;
        }

    }
}













