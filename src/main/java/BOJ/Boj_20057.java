package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * 		토네이도 시전
 * 		-> 격자의 가운데 칸 부터 토네이도의 이동이 시작된다
 * 		-> 토네이도는 한 번에 한칸씩 이동한다.
 * 		-> 토네이도가 한 칸 이동할 때마다 모래는 일정한 비율로 흩날린다.
 * 		-> 토네이도는 가운데 칸에서 부터 한 칸씩 움직인다
 *   	(3,3)(3,2)
 *   	(4,2)(4,3)(4,4),
 *   	(3,4)(2,4),(1,3)(1,2)(1,1)
 *   	(2,1)(3,1)(4,1)(5,1) ---
 */
public class Boj_20057 {
	static int n;
	static int[][] arr;
	static boolean[][] visited;
	static int d = 0;
	static int answer = 0;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};

	static int[][] torX = {{-1,1,-1,1,-1,1,0,-2,2,0},{-1,-1,0,0,1,1,2,0,0,1},{-1,1,-1,1,-1,1,0,-2,2,0}, {1,1,0,0,-1,-1,-2,0,0,-1}};
	static int[][] torY = {{1,1,0,0,-1,-1,-2,0,0,-1},{-1,1,-1,1,-1,1,0,-2,2,0} ,{-1,-1,0,0,1,1,2,0,0,1},{-1,1,1,-1,1,-1,0,2,-2,0}};
	static int[] sand = { 1,1,7,7,10,10,5,2,2 };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visited = new boolean[n][n];

		StringTokenizer st;
		for( int i =0; i < n; i ++ ){
			 st = new StringTokenizer(br.readLine());
			 for( int j=0; j < n; j++ ){
				 arr[i][j] = Integer.parseInt(st.nextToken());
			 }
		}

		int x = n/2;
		int y = n/2;

		while( true ){

			if( x == 0 && y == 0 ){
				break;
			}

			// 왼쪽에 있는 칸이 visited가 아닐 때
			// 왼쪽으로 꺽어야함
			visited[x][y] = true;

			if( x == n/2 && y == n/2 ){
				int nx = x + dx[d];
				int ny = y + dy[d];

				move(nx,ny);
				x = nx;
				y = ny;
				continue;
			}


			if( !visited[x+dx[(d+1)%4]][y+dy[(d+1)%4]] ){
				d = ( d+1 )% 4;
			}


			int nx = x + dx[d];
			int ny = y + dy[d];

			arr[nx][ny] += arr[x][y];
			arr[x][y] = 0;

			move(nx,ny);
			x = nx;
			y = ny;

		}

		System.out.println(answer);


	}
	private static void move( int x , int y ){

		int allSand = arr[x][y];
		int alpha = allSand;

		for( int i = 0; i <  9; i ++ ){
			int nx = x + torX[d][i];
			int ny = y + torY[d][i];

			int s = allSand*sand[i]/100;

			if( nx < 0 || ny < 0 || nx >= n || ny >= n ){
				answer += s;
			}
			else
				arr[nx][ny] += s;
			alpha -= s;
		}

		int alphaX = x + torX[d][9];
		int alphaY = y + torY[d][9];

		if( alphaX < 0 || alphaY < 0 || alphaY >= n || alphaX >= n ){
			answer += alpha ;
		}else {
			arr[alphaX][alphaY] += alpha ;
		}

		arr[x][y] = 0;

	}
}
