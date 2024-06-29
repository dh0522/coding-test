package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Prg_159993 {
	public static void main(String[] args) {
		Prg_159993 sol = new Prg_159993();
		System.out.println(sol.solution( new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"} ));
	}
	static int[][] visited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int r,c;
	static int[] start, end;
	static char[][] map;
	private static int solution( String[] maps ){

		r = maps.length;
		c = maps[0].length();

		map = new char[r][c];
		visited = new int[r][c];

		start = new int[2];
		end = new int[2];

		for(int i =0; i < r; i++ ){
			for( int j =0 ; j< c ; j++ ){
				map[i][j] = maps[i].charAt(j);

				if(map[i][j] == 'S'){
					start[0] = i;
					start[1] = j;
				}else if( map[i][j] == 'E' ){
					end[0] = i;
					end[1] = j;
				}

			}
		}

		findLever();

		if( visited[end[0]][end[1]] == 0 )
			return -1;
		return visited[end[0]][end[1]];

	}
	private static void findLever(){

		Queue<int[] > q = new LinkedList<>();
		q.add( new int[]{start[0],start[1]});
		visited[start[0]][start[1]] = 0;

		int[] lever = new int[2];
		int num = 0;

		while( !q.isEmpty() ){
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];

			if( map[x][y] =='L' ){
				num = visited[x][y];
				lever[0] = x;
				lever[1] = y;
				break;
			}

			for( int i =0 ; i< 4; i++ ){
				int nx = x + dx[i];
				int ny = y + dy[i];

				if( nx < 0 || ny < 0 || nx >= r || ny >= c )
					continue;
				if( visited[nx][ny] != 0 || map[nx][ny] == 'X' )
					continue;

				visited[nx][ny] = visited[x][y] + 1;
				q.add( new int[]{nx,ny} );

			}
		}

		for( int i = 0 ; i < r; i++ )
			Arrays.fill( visited[i] , 0 );
		if( num == 0 )
			return;
		else{
			findExit(num,lever);
		}
	}
	private static void findExit( int num , int[] lever ){

		Queue<int[]> q = new LinkedList<>();
		q.add( lever );
		visited[lever[0]][lever[1]] = num;
		boolean possible = false;

		while( !q.isEmpty() ){
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];

			if( map[x][y] == 'E' ){
				possible = true;
				return;
			}

			for( int i = 0 ; i< 4; i ++ ){
				int nx = x + dx[i];
				int ny = y + dy[i];

				if( nx < 0 || ny < 0 || nx >= r || ny >= c )
					continue;
				if( visited[nx][ny] != 0 || map[nx][ny] == 'X' )
					continue;

				visited[nx][ny] = visited[x][y] + 1;
				q.add( new int[]{nx,ny} );

			}

		}


	}
}
