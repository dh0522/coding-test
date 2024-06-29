package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Prg_81302 {
	public static void main(String[] args) {
		Prg_81302 sol = new Prg_81302();
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
			{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		int[] answer = sol.solution( places );
		System.out.println(Arrays.toString(answer));
	}
	public static int[] solution(String[][] places){
		int[] answer = new int[5];
		for( int i=0; i < 5; i++ ){
			answer[i] = search(places[i]);
		}
		return answer;
	}

	private static int search( String[] place ){

		char[][] seat = new char[5][5];
		for( int i =0 ;i < 5; i++ ){
			seat[i] = place[i].toCharArray();
		}

		for( int i =0 ;i < 5; i++ ){
			for( int j =0 ;j < 5; j++ ){

				if( seat[i][j] == 'P' ){
					if( !isPossible(i,j,seat) ){
						return 0;
					}
				}
			}
		}

		return 1;
	}
	private static boolean isPossible( int x , int y , char[][] seat ){

		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		boolean[][] visited = new boolean[5][5];

		Queue<int[]> q = new LinkedList<>();
		q.add( new int[]{x,y} );
		visited[x][y] = true;

		while( !q.isEmpty() ){
			int[] now = q.poll();

			for( int i =0 ; i < 4; i++ ){
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];

				if( nx < 0 || ny < 0 || nx >= 5 || ny >= 5 )
					continue;

				if( visited[nx][ny] || seat[nx][ny] == 'X' )
					continue;

				if( Math.abs(x-nx)+ Math.abs(y-ny) > 2 )
					continue;

				if( seat[nx][ny] == 'P' ){
					return false;
				}

				q.add( new int[]{nx,ny});
				visited[nx][ny] = true;

			}
		}

		return true;

	}
}
