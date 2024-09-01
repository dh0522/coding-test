package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_23288 {
	static int n,m,k;
	static int[][] map;
	static int[] dx= {0,1,0,-1}; // 동 남 서 북
	static int[] dy= {1,0,-1,0};
	static int[] dice = { 2,1,5,6,4,3 }; // 뒤위앞밑 왼오
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		int x = 0, y = 0;

		for( int i=0;i < n; i++ ){
			st = new StringTokenizer(br.readLine());
			for( int j=0; j< m; j++ )
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		int score = 0;
		int dir = 0;
		while( k-- > 0 ){

			// 주사위가 이동 방향으로 한 칸 굴러간다.
			// 만약, 이동 방향에 칸이 없다면, 이동 방향을 반대로 한 다음 한 칸 굴러간다

			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if( nx < 0 || nx >= n || ny < 0 || ny >= m ){
				nx = x - dx[dir];
				ny = y - dy[dir];

				dir = (dir+2)%4;
			}
			moveDice( dir );
			score += getScore( nx, ny );


			if( dice[3] > map[nx][ny] )
				dir = (dir+1)%4;
			else if( dice[3] < map[nx][ny] )
				dir = ( dir-1 + 4)%4;

			x = nx;
			y = ny;
		}

		System.out.println(score);

	}
	static int getScore( int x , int y ){

		int b = map[x][y];
		int count = 1;

		Queue<int[]> q= new LinkedList<>();
		q.add( new int[]{x,y} );

		boolean[][] visited = new boolean[n][m];
		visited[x][y] = true;

		while( !q.isEmpty() ){
			int[] now = q.poll();

			for( int i=0; i < 4; i++ ){
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];

				if( nx < 0 || ny < 0 || nx >=n || ny >= m )
					continue;
				if( visited[nx][ny] )
					continue;

				if( map[nx][ny] == b ) {
					count++;
					visited[nx][ny] = true;
					q.add(new int[]{nx,ny});
				}
			}
		}


		return b*count;
	}
	static void moveDice( int nowDir ){

		switch (nowDir){
			case 0:
				int temp1 = dice[3];
				dice[3] = dice[5];
				dice[5] = dice[1];
				dice[1] = dice[4];
				dice[4] = temp1;

				break;
			case 1:
				int temp2 = dice[0];
				dice[0] = dice[3];
				dice[3] = dice[2];
				dice[2] = dice[1];
				dice[1] = temp2;
				break;

			case 2:
				int temp3 = dice[1];
				dice[1] = dice[5];
				dice[5] = dice[3];
				dice[3] = dice[4];
				dice[4] = temp3;
				break;

			case 3:
				int temp4 = dice[0];
				dice[0] = dice[1];
				dice[1] = dice[2];
				dice[2] = dice[3];
				dice[3] = temp4;
				break;
		}

	}
}
