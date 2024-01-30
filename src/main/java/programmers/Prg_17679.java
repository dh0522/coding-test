package programmers;
import java.util.*;
public class Prg_17679 {
    public static void main(String[] args) {

        Prg_17679 sol = new Prg_17679();
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(sol.solution(4,5,board));

    }

    char[][] block;
    int[] dx = { 1, 0, 1 };
    int[] dy = { 0, 1, 1 };
    boolean[][] isPossible;
    int answer = 0;

    private int solution( int m, int n , String[] board){

        block = new char[m][n];
        for( int i =0; i < m; i++  ){
            block[i] = board[i].toCharArray();
        }

        while( true ){

            int newerase = 0;
            isPossible = new boolean[m][n];

            for( int i =0 ;i < m-1 ; i++ ){
                for(int j = 0 ; j < n-1 ; j++ ){

                    char now = block[i][j];
                    if(now == '.' )
                        continue;

                    int num = 0;
                    int x = i;
                    int y = j;

                    for( int k =0 ;k < 3; k++ ){
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if( block[nx][ny] != now )
                            break;
                        num++;
                    }

                    if(num == 3){
                        for( int k = 0; k < 3; k ++ ){

                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            isPossible[x][y] = true;
                            isPossible[nx][ny] = true;
                        }
                    }
                }
            }

            for( int i =0 ;i <m ; i++ ){
                for( int j =0 ;j <n ;j ++ ){
                    if( isPossible[i][j] ) {
                        newerase++;
                        block[i][j] = '.';
                    }
                }
            }



            answer += newerase;

            int[] num = down(m,n);
            m = num[0];
            n = num[1];
            if( newerase == 0 )
                break;



        }

        return answer;
    }
    public int[] down( int m , int n ){

        // m ,n 이 0,0 = 축 으로 봐야함
        ArrayList<String> al = new ArrayList<>();
        int max = 0;
        for( int i = n-1; i >= 0; i -- ){
            StringBuilder sb  = new StringBuilder();
            for( int j = m-1; j>=0 ; j-- ){
                if( block[j][i] != '.' )
                    sb.append(block[j][i]);
            }

            max = Math.max( max , sb.length() );
            al.add(sb.toString());

        }
        Collections.reverse(al);

        ArrayList<String> list = new ArrayList<>();


        int temp = 0;
        for( int i = 0 ; i < n; i++ ){

            StringBuilder tmp = new StringBuilder(al.get(i));

            while( tmp.length() != max )
                tmp.append(".");
            tmp.reverse();

            for( int j =0; j< max ;j ++ ){
                block[j][i] = tmp.charAt(j);
            }
        }

        return new int[]{max, n};
    }

}