package programmers;
import java.util.*;
public class Prg_154540 {
    public static void main(String[] args) {

        Prg_154540 sol = new Prg_154540();

        int[] ans1 = sol.solution( new String[] {  "X591X","X1X5X","X231X", "1XXX1" });
        int[] ans2 = sol.solution( new String[] { "XXX","XXX","XXX"  });

        for( int i : ans1)
            System.out.print(i+" ");
        System.out.println();

        for( int i : ans2)
            System.out.print(i+" ");
        System.out.println();
    }

    private int[] dx = { 1,0,-1,0};
    private int[] dy = { 0,1,0,-1};
    private int[] solution(String[] maps ){

        char[][] map = new char[maps.length][maps[0].length()];

        for( int i =0 ; i < maps.length ;i++ ){
            for( int j =0 ; j < maps[0].length(); j++ ){
                map[i][j] = maps[i].charAt(j);
            }
        }

        int[] answer = search(map);
        return answer;

    }

    public int[] search( char[][] map ){

        ArrayList<Integer> list = new ArrayList<>();

        for( int i = 0 ; i< map.length ;i++ ){
            for( int j = 0; j< map[0].length ; j++ ){

                if( map[i][j] == 'X' )
                    continue;

                Queue<Point> q = new LinkedList<>();
                q.add(new Point(i,j));

                int sum = map[i][j] - '0';
                map[i][j] = 'X';
                while( !q.isEmpty() ){

                    Point p = q.poll();

                    int x = p.x;
                    int y = p.y;

                    for( int d =0; d < 4; d++ ){

                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if( nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length )
                            continue;

                        if( map[nx][ny] == 'X'  )
                            continue;

                        sum += (map[nx][ny] - '0') ;
                        q.add(new Point(nx,ny));
                        map[nx][ny] = 'X';



                    }
                }

                list.add(sum);
            }

        }

        if( list.size() == 0 )
            return new int[]{-1};

        int[] ans = new int[list.size()];

        Collections.sort(list);

        for( int i =0 ;i < list.size(); i++ )
            ans[i] = list.get(i);


        return ans;

    }


    class Point{
        int x;
        int y;
        public Point(int x, int y ){
            this.x = x;
            this.y = y;
        }
    }
}