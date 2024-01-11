package programmers;

public class Prg_1829 {
    public static void main(String[] args) {
        Prg_1829 sol = new Prg_1829();

        int[] ans = sol.solution(6,4,
                new int[][] { { 1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1},
                        {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1 } } );

        for( int i : ans )
            System.out.print(i+" ");
        System.out.println();

    }

    boolean[][] visited;
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    int[] answer = new int[2];
    int MaxArea = 0;
    int size = 1;

    public int[] solution(int m, int n, int[][] picture) {
        int numArea = 0;

        visited = new boolean[m][n];
        for( int i = 0 ; i < m ; i++ ){
            for( int j= 0; j < n ; j++ ){

                if( visited[i][j] || picture[i][j] == 0 )
                    continue;

                MaxArea = Math.max( area(i,j,picture) , MaxArea );
                numArea ++;
                size = 1;
            }
        }
        answer[0] = numArea;
        answer[1] = MaxArea;
        return answer;
    }

    private int area ( int x , int y, int[][] picture){

        int now = picture[x][y];
        visited[x][y] = true;

        for( int i =0 ;i < 4; i++ ){

            int nx = x + dx[i];
            int ny = y + dy[i];

            if( nx >= picture.length || ny >= picture[0].length || nx < 0 || ny <0 )
                continue;
            if( picture[nx][ny] != now )
                continue;
            if(visited[nx][ny] )
                continue;
            area( nx, ny, picture );
            size++;

        }

        return size;
    }
}