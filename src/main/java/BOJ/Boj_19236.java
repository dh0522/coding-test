package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_19236 {
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,-1,-1,-1,0,1,1,1};
	static int answer = Integer.MIN_VALUE ;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;


		int[][] arr = new int[4][4]; // arr[i][j] = (I,j) 칸에 있는 물고기 인덱스
		Fish[] fish = new Fish[17];
		for (int i=0;i < 4; i++ ){
			st = new StringTokenizer(br.readLine());

			for( int j =0; j < 4; j ++ ){
				int index = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken())-1; // direction

				fish[index] = new Fish( i, j , dir ,true );
				arr[i][j] = index;

			}
		}

		dfs ( 0,0  ,0, fish , arr );

		System.out.println(answer);

	}
	private static void dfs( int x , int y, int sum , Fish[] fish, int[][] arr){


		int nowFish = arr[x][y];
		sum += nowFish;
		int dir = fish[nowFish].dir;
		//  shark = x,y,dir;

		fish[ nowFish ].alive = false;

		answer = Math.max( sum, answer );

		// 물고기들 이동하기
		for( int i =1; i<= 16; i++ ){
			if( fish[i].alive ){

				// x ,y = 상어 위치 i= 지금 움직일 물고기
				moveFish( x, y, i , fish , arr );
			}
		}

		// 상어 이동하기 최대 3칸 이동 가능하다.
		for( int i =1; i <=3; i++ ){

			int nx = x + dx[dir]*i;
			int ny = y + dy[dir]*i;


			// 범위를 넘거나 fish가 없는 칸은 안돼
			if( nx< 0 || ny< 0 || nx >= 4 || ny >= 4 )
				continue;
			if( !fish[arr[nx][ny]].alive )
				continue;

			// nx, ny = 상어가 이동하기 위한 칸
			Fish[] tmpFish = new Fish[17];
			for (int j = 1; j < 17; j++) {
					tmpFish[j] = new Fish(fish[j].x, fish[j].y, fish[j].dir, fish[j].alive );
			}

			int[][] tmpArr = new int[4][4];
			for( int k =0; k < 4; k++ )
				tmpArr[k] = arr[k].clone();

			dfs( nx, ny, sum , fish , arr );

			fish = tmpFish;
			arr = tmpArr;

		}


	}
	private static void moveFish( int sharkX, int sharkY, int idx , Fish[] fish , int[][] arr ){

		// idx번째 물고기 이동하기

		/**
		 *   놓치고 있던 것 = shark 의 위치 !
		 */

		Fish nowFish = fish[idx];
		int dir = nowFish.dir;

		for( int i =0 ; i < 8; i++ ){

			int x = nowFish.x + dx[dir];
			int y = nowFish.y + dy[dir];

			if( x  >= 0 && y >= 0 && x < 4 && y < 4 && !( sharkX == x && sharkY == y )  ){

				int next = arr[x][y];
				arr[nowFish.x][nowFish.y] = next;
				arr[x][y] = idx;

				fish[next].x = nowFish.x;
				fish[next].y = nowFish.y;

				fish[idx].x = x;
				fish[idx].y = y;
				fish[idx].dir = dir;
				return;
			}
			dir = (dir+1)%8;
		}

	}




	static class Fish {
		int x, y;
		int dir;
		boolean alive;
		Fish(int x, int y, int dir ,boolean alive ) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.alive = alive;
		}
	}
}
