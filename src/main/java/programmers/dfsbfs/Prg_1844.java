package programmers.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class Prg_1844 {
    public static void main(String[] args) {

        Prg_1844 sol = new Prg_1844();

        int ans = sol.solution( new int[][] {{1,0,1,1,1},{1,0,1,0,1},
                {1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}});
        System.out.println(ans);

        int ans2 = sol.solution( new int[][] {{1,0,1,1,1},{1,0,1,0,1},
                {1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}});

        System.out.println(ans2);
    }
    class Point{
        int x,y;
        public Point( int x , int y ){
            this.x = x;
            this.y = y;
        }
    }
    static boolean[][] visited ;
    static int[] dx = { 0 , 1, 0, -1};
    static int[] dy = {1,0,-1,0};
    private int solution( int[][] maps ){

        visited = new boolean[maps.length][maps[0].length];

        return bfs(maps , 0, 0 );

    }

    private int bfs ( int[][] maps , int x , int y ){

        Queue<Point> q = new LinkedList<>();
        q.add( new Point(x,y) );
        visited[x][y] = true;

        while( !q.isEmpty() ){

            Point now = q.poll();
            x = now.x;
            y = now.y;

            for( int i =0; i< 4; i++ ){

                int nx = x + dx[i];
                int ny = y + dy[i];

                if( nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length )
                    continue;

                if( visited[nx][ny] || maps[nx][ny] == 0 )
                    continue;

                visited[nx][ny] = true;
                maps[nx][ny] = maps[x][y] + 1;

                if( nx == maps.length -1 && ny == maps[0].length -1 )
                    continue;

                q.add( new Point( nx, ny) );

            }
        }

        return ( maps[maps.length -1 ][maps[0].length -1 ] == 1 ? -1 : maps[maps.length-1][maps[0].length-1]);
    }
}
