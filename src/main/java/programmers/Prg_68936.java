package programmers;
import java.util.Arrays;

public class Prg_68936 {
    public static void main(String[] args) {
        Prg_68936 sol = new Prg_68936();


        int[][] arr = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},
                {0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},
                {0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};

        int[] ans = sol.solution( arr );

        for( int i : ans )
            System.out.print(i+" ");
        System.out.println();
    }
    private boolean[][] visited;
    private int[] answer = new int[2];
    private int[] solution(int[][] arr) {

        int n = arr.length;
        visited = new boolean[n][n];
        for( int i =0 ;i < n; i++ )
            Arrays.fill( visited[i] ,false );

        for( int i = 0 ;i < n; i ++ ){
            for( int j = 0 ; j < n; j ++ ){
                if( arr[i][j] == 0 )
                    answer[0]++;
                else
                    answer[1]++;
            }
        }

        if( answer[0] == n*n ){
            return new int[]{1,0};
        }else if( answer[1] == n*n ){
            return new int[]{0,1};
        }

        compress( arr , n );
        return answer;
    }
    private void compress( int[][] arr , int n ){


        int now = n/2;

        while( now != 1 ){

            for( int i =0 ; i < n ; i+=now ){
                for( int j = 0 ; j < n; j += now ){
                    if( visited[i][j] )
                        continue;
                    if( isSame( arr , i , j , now ) ) {

                        int num = now*now-1;
                        answer[arr[i][j]] -= num;
                    }
                }
            }

            now/=2;
        }
    }

    private boolean isSame( int[][] arr, int x , int y , int len ){

        int number = arr[x][y];

        for( int i = x ; i < x +len ; i ++ ){
            for( int j = y ; j < y + len ; j++ ){
                if( arr[i][j] != number )
                    return false;
            }
        }

        for( int i = x ; i < x +len ; i ++ ){
            for( int j = y ; j < y + len ; j++ ){
                visited[i][j] = true;
            }
        }

        return true;

    }
}
