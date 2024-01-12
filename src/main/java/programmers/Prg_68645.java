package programmers;

public class Prg_68645 {
    public static void main(String[] args) {
        Prg_68645 sol = new Prg_68645();

        int[] ans1 = sol.solution(4);
        int[] ans2 = sol.solution(5);
        int[] ans3 = sol.solution(6);

        for( int i : ans1)
            System.out.print(i +" ");
        System.out.println();

        for( int i : ans2)
            System.out.print(i +" ");
        System.out.println();

        for( int i : ans3)
            System.out.print(i +" ");
        System.out.println();

    }

    public int[] solution ( int n ){

        int[] dx = {1,0,-1};
        int[] dy = {0,1,-1};
        int[][] map = new int[n][n];

        int x = 0;
        int y = 0;
        int dir = 0;
        int num = 1;

        while( true ) {

            map[x][y] = num++;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if( nx == n || ny == n || map[nx][ny] != 0 ){

                dir = (dir + 1) % 3;
                nx = x + dx[dir];
                ny = y + dy[dir];
                if( nx == n || ny == n || map[nx][ny] != 0 )
                    break;
            }
            x = nx;
            y = ny;

        }
        int k = 0;
        int[] ans = new int[(n*(n+1))/2];

        for(int i =0 ;i < n; i ++ ){
            for(int j =0 ; j<n ; j++ ){
                if( map[i][j] == 0)
                    break;
                ans[k++] = map[i][j];
            }
        }

        return ans;
    }
}
