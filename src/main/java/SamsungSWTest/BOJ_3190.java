package SamsungSWTest;
import java.util.*;
import java.io.*;

public class BOJ_3190 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int n,k,l;
    static int[][] board ;
    static HashMap<Integer,String> change = new HashMap<>();
    static List<int[]> now = new LinkedList<>();
    static int ans = 0;

// L = 왼쪽으로 90도 //  D = 오른쪽으로 90도
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 보드의 크기 NxN
        k = Integer.parseInt(br.readLine()); // 사과의 개수 k

        StringTokenizer st ;
        board = new int[n+1][n+1];

        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] = 1;
        }
        l = Integer.parseInt(br.readLine());// l = 뱀의 방향 변환 횟수
        for( int i=0; i<l ; i++){
            st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            change.put(sec,st.nextToken());
        }

        dummy(1,1);
        System.out.println(ans);

    }
    static void dummy(int x, int y){

        now.add(new int[]{x,y});
        int d = 0;

        while( true ){



            int nx = x + dx[d];
            int ny = y + dy[d];
            ans ++;// 1초 흐름

            if( nx <=0 || ny <= 0 || nx >n || ny > n)
                return;

            for(int i=0; i<now.size();i++){
                if( nx == now.get(i)[0] && ny == now.get(i)[1])
                    return;
            }


            if( board[nx][ny] == 1 )
                board[nx][ny] = 0;


             else  // 사과 없을때
                now.remove(0);


            now.add(new int[]{nx,ny});

            if( change.containsKey(ans) ) {
                String dir = change.get(ans);
                if( dir.equals("D") ){
                    d +=1;
                    if( d == 4)
                        d = 0;
                }
                else{
                    d -= 1;
                    if(d == -1)
                        d = 3;
                }

            }
            x = nx;
            y = ny;


        }

    }
}
