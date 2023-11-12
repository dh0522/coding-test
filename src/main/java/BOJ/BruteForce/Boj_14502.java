package BOJ.BruteForce;
import java.util.*;
import java.io.*;
public class Boj_14502 {
    static int n,m;
    static int[][] map;
    // 2의 위치를 알앙야하지않을ㄱ까
    static int[] virus;
    static int[] dx ={-1,1,0,0};
    static int[] dy ={0,0,-1,1};
    static int safezone = 0;
    public static void main(String[] args ) throws IOException{

        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() );

        n = Integer.parseInt( st.nextToken() );
        m = Integer.parseInt( st.nextToken() );

        map = new int[n][m];

        for( int i= 0;i< n; i++){
            st = new StringTokenizer( br.readLine() );
            for( int j = 0; j< m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }

        }
        wall(0);

        System.out.println(safezone);

    }
    public static void wall( int wallnum ){ // num = 지금 세운 벽의 개수

        if( wallnum == 3 ) {
            virus();
            return;
        }

        for( int i=0; i< n; i++ ){
            for(int j =0; j<m; j++){
                if( map[i][j] == 0 ){
                    map[i][j] = 1;
                    wall(wallnum+1);
                    map[i][j] = 0;
                }
            }
        }

    }

    public static void virus(){

        Queue<int[]> q = new LinkedList<>();

        int[][] tmpmap = new int[n][m];

        for(int i=0; i<n;i++){
            for(int j = 0; j<m; j++){
                tmpmap[i][j] = map[i][j];
                if(map[i][j] ==2)
                    q.add(new int[]{i,j});
            }
        }


        while( !q.isEmpty() ){
            int[] tmp = q.poll();
            for(int i=0; i<4; i++){
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];

                if( nx>=0 && ny >= 0 && nx<n && ny < m){
                    if( tmpmap[nx][ny] == 0 ){
                        q.add(new int[] {nx,ny});
                        tmpmap[nx][ny] = 2;
                    }


                }
            }



        }
        issafezone(tmpmap);

    }
    public static void issafezone(int[][] tmpmap ){

        int max = 0;
        for( int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(tmpmap[i][j] == 0)
                    max++;
            }
        }
        if( max> safezone)
            safezone = max;

    }
}
