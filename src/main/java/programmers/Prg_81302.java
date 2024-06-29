package programmers;

import java.util.LinkedList;
import java.util.List;

public class Prg_81302 {
	public static void main(String[] args) {
		Prg_81302 sol = new Prg_81302();
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
			{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		int[] answer = sol.solution( places );
		for( int i : answer )
			System.out.print( i +" ");
		System.out.println();
	}
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int[] mandx = {1,1,-1,-1};
	static int[] mandy = {1,-1,-1,1};
	static char[][] seat;
	public static int[] solution( String[][] places ){

		int[] answer = new int[5];
		seat = new char[5][5];

		for( int i = 0; i< 5 ; i++ ){
			for( int j =0 ; j < 5; j++ )
				seat[j] = places[i][j].toCharArray();

			int result = correct();
			answer[i] = result;

		}

		return answer;
	}
	private static int correct(){

		int answer = 1;

		List<int[]> list = new LinkedList<>();

		for( int i = 0 ; i < 5; i ++ ){
			for( int j = 0; j< 5; j++ ){
				if( seat[i][j] == 'P' ){
					list.add( new int[] {i,j} );
				}
			}
		}

		for( int i = 0 ; i < list.size() ; i ++ ){
			int[] person = list.get(i);

			if( !next(person) ){
				answer = 0;
				break;
			}

			// 맨허턴 거리에 있는지 판단하기
			if( !manhattan(person) ){
				answer = 0;
				break;
			}
		}
		return answer;

	}
	private static boolean next( int[] person ){


		for( int i = 0 ; i< 4; i++ ){
			int nx = person[0] + dx[i];
			int ny = person[1] + dy[i];

			if ( nx < 0 || ny < 0 || nx >= 5 || ny >= 5 )
				continue;

			if( seat[nx][ny] == 'P' )
				return false;
			else if(seat[nx][ny] == 'O') {

				nx += dx[i];
				ny += dy[i];

				if ( nx < 0 || ny < 0 || nx >= 5 || ny >= 5 )
					continue;

				if( seat[nx][ny] == 'P' )
					return false;
			}
		}
		return true;
	}
	public static boolean manhattan( int[] person ){

		for( int i = 0 ; i< 4; i++ ){
			int nx = person[0] + mandx[i];
			int ny = person[1] + mandy[i];

			if ( nx < 0 || ny < 0 || nx >= 5 || ny >= 5 )
				continue;

			if( seat[nx][ny] == 'P' ){

				if( seat[nx][person[1]] == 'O')
					return false;
				if( seat[person[0]][ny] == 'O'){
					return false;
				}
			}
		}
		return true;
	}

}
