package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_19236 {
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,-1,-1,-1,0,1,1,1};
	static int answer = Integer.MIN_VALUE ;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;


		int[][] arr = new int[4][4];
		Fish[] fish = new Fish[17];
		for (int i=0;i < 4; i++ ){
			st = new StringTokenizer(br.readLine());

			for( int j =0; j < 4; j ++ ){
				int index = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken())-1; // direction

				Fish now = new Fish( i, j , dir , true );

				arr[i][j] = index;
				fish[index] = now;
			}
		}

		dfs ( 0,0,0,0  , fish , arr );
		System.out.println(answer);

	}
	private static void dfs( int x , int y, int dir, int sum ,Fish[] fish,  int[][] arr ){

		// 상어가 물고기 먹고 dir 정하기
		sum += arr[x][y];
		dir = fish[arr[x][y]].dir;
		fish[arr[x][y]].alive = false;

		arr[x][y] = -100;

		answer = Math.max( sum, answer );

		// 물고기들 이동하기
		for( int i =1; i<= 16; i++ ){
			if( fish[i].alive ){
				moveFish( i , fish , arr );
			}
		}

		// 상어 이동하기
		for( int i =1; i <=3; i++ ){

			int nx = x + dx[dir]*i;
			int ny = y + dy[dir]*i;

			if( nx< 0 || ny< 0 || nx >= 4 || ny >= 4 || arr[nx][ny] == -100 || !fish[ arr[nx][ny] ].alive )
				continue;

			Fish[] tmpFish = new Fish[17];
			for( int k=0; k < 17; k++ ) {
				tmpFish[k] = fish[k];
			}
			int[][] tmpArr = new int[4][4];
			for( int k =0; k < 4; k++ )
				tmpArr[k] = arr[k].clone();

			tmpArr[x][y] = 0;

			dfs( nx, ny, dir , sum , fish , arr );

			fish = tmpFish;
			arr = tmpArr;

		}


	}
	private static void moveFish( int idx , Fish[] fish , int[][] arr ){

			// idx번째 물고기 이동하기
			Fish nowFish = fish[idx];
			int dir = nowFish.dir;


			for( int i =0; i < 8; i++ ){
				 int x = nowFish.x + dx[dir];
				 int y = nowFish.y + dy[dir];

				 if( x  > 0 && y > 0 && x < 4 && y < 4 && arr[x][y] != -100 ){

					 if( arr[x][y] == 0 ) {

						 arr[nowFish.x][nowFish.y] = 0;
						 arr[x][y] = idx;

						 Fish newFish = new Fish(x,y,dir,true);
						 fish[idx] = newFish;

					 }else{

						 int next = arr[x][y];

						 fish[next].x = nowFish.x;
						 fish[next].y = nowFish.y;

						 fish[idx].x = x;
						 fish[idx].y = y;
						 fish[idx].dir = dir;

						 arr[x][y] = idx;
						 arr[nowFish.x][nowFish.y] = next;

					 }

					 return;
				 }

				dir = (dir+1)%8;
			}


		}

	static class Fish {
		int x, y;
		int dir;
		boolean alive ;
		Fish(int x, int y, int dir , boolean alive ) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.alive = alive;
		}
	}
}
