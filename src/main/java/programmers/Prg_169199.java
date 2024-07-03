package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Prg_169199 {
	public static void main(String[] args) {

		Prg_169199 sol = new Prg_169199();

		System.out.println(sol.solution( new String[] {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
		System.out.println(sol.solution( new String[]{ ".D.R", "....", ".G..", "...D" }));
	}
	static char[][] map;
	static int[] dx = { 1,0,-1,0};
	static int[] dy = { 0,1,0,-1};
	static int r , c;
	private static int solution(String[] board){

		r = board.length;
		c = board[0].length();

		map = new char[r][c];
		int[] start = new int[2];

		for( int i =0 ; i< r; i++ ){
			for( int j = 0 ; j < c ; j++ ){
				map[i][j] = board[i].charAt(j);
				if( map[i][j] == 'R' ){
					map[i][j] = '.';
					start[0] = i;
					start[1] = j;
				}
			}
		}

		return bfs(start , r, c );
	}
	public static int bfs(int[] start , int r , int c ){

		Queue<int[]> q = new LinkedList<>();
		q.add( start );

		int[][] visited = new int[r][c];
		visited[start[0]][start[1]] = 0;


 		while( !q.isEmpty() ){

			int[] now = q.poll();
			int x = now[0];
			int y = now[1];

			if( map[x][y] == 'G' ){
				return visited[x][y];
			}

			for( int i =0 ; i< 4; i++ ){

				int nx = x ;
				int ny = y ;
				while( nx >=0 && ny >= 0 && nx < r && ny < c && map[nx][ny] != 'D' ){
					nx += dx[i];
					ny += dy[i];

				}

				nx -= dx[i];
				ny -= dy[i];

				if( visited[nx][ny] != 0 || ( x == nx && y == ny ) )
					continue;

				visited[nx][ny] = visited[x][y] + 1;
				q.add( new int[] { nx,ny} );

			}

		}

		return -1;
	}

}
