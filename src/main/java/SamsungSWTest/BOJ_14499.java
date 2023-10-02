package SamsungSWTest;
import java.util.*;
import java.io.*;

public class BOJ_14499 {
    static int n,m,x,y,k;
    static int[][] map ;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0}; // 동서북남
    static int[] dice = new int[7];
    // 위 아래 앞면 뒷면 좌 우
    public static void main(String[] args) throws IOException {

        BufferedReader br =  new BufferedReader( new InputStreamReader( System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());// 지도 크기 N by M
        x = Integer.parseInt(st.nextToken()); // 주사위 위치
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()); // k = 명령의 개수


        map = new int[n][m];

        for( int i=0 ;i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j= 0; j<m;j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }


        st = new StringTokenizer(br.readLine());
        for( int i=0; i< k; i++){
            int dir = Integer.parseInt(st.nextToken()) -1 ;
            movemap(dir);
        }

        // 이동한 칸 이 0 이면 그 칸은 주사위의 바닥면에 쓰인 수가 됨
        // 0 이 아니면 칸에 쓰여있는 수가 주사위의 바닥면이 됨 . 주사위의 칸은 0 이됨
        // 이동 -> 이동한 칸 수 x 확인 -> 주사위의 바닥면 = x -> 지도의 칸 = 0

    }
    static void movemap(int d){

        // 남북이면 dicedy

        int nx = x + dx[d];
        int ny = y + dy[d];

        if( nx<0 || ny <0 || nx>=n || ny>= m ) {
            return;
        }
        movedice(d);
        System.out.print(dice[0] +" ");
        x = nx;
        y = ny;

        if(map[nx][ny] == 0 )
            map[nx][ny] = dice[1];
        else {
            dice[1] = map[nx][ny];
            map[nx][ny] = 0;
        }

    }
    static void movedice( int dir ){

        // 동 0 서 1 북 2 남 3
        // 위 아래 앞면 뒷면 좌 우
        if( dir == 0 ){ // 동쪽
            int tmp = dice[0];
            dice[0] = dice[4];
            dice[4] = dice[1];
            dice[1] = dice[5];
            dice[5] = tmp;


        }
        else if( dir == 1) { // 서쪽
            int tmp = dice[0];
            dice[0] = dice[5];
            dice[5] = dice[1];
            dice[1] = dice[4];
            dice[4] = tmp;


        }
        else if( dir == 2){

            int tmp = dice[0];
            dice[0] = dice[2];
            dice[2] =dice[1];
            dice[1] = dice[3];
            dice[3] = tmp;


        }
        else{
            int tmp = dice[0];
            dice[0] = dice[3];
            dice[3] =dice[1];
            dice[1] = dice[2];
            dice[2] = tmp;
        }


    }


}
