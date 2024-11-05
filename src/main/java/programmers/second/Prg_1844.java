package programmers.second;

import java.util.LinkedList;
import java.util.Queue;

public class Prg_1844 {
	public static void main(String[] args) {
		Prg_1844 sol = new Prg_1844();

		System.out.println(sol.solution( new int[][]{ { 1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
		System.out.println(sol.solution( new int[][]{ { 1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));
	}
	private static int solution( int[][] maps ){
		int answer = 0;

		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};

		int[][] visited = new int[maps.length][maps[0].length];
		visited[0][0] = 1;

		Queue<int[]> q = new LinkedList<>();
		q.add( new int[]{0,0} );

		while( !q.isEmpty() ){
			int[] now = q.poll();
			if( now[0] == maps.length -1 && now[1] == maps[0].length -1 ){
				answer = visited[now[0]][now[1]];
				break;
			}

			for( int d = 0; d < 4; d++ ){
				int nx = now[0] + dx[d];
				int ny = now[1] + dy[d];

				if( nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length )
					continue;

				if( visited[nx][ny] != 0 )
					continue;

				if( maps[nx][ny] == 0 )
					continue;

				visited[nx][ny] = visited[now[0]][now[1]] + 1;
				q.add( new int []{nx,ny} );
			}
		}


		return answer == 0 ? -1 : answer ;
	}
}
