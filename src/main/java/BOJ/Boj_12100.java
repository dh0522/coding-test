package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_12100 {
	static int n;
	static int[][] arr;
	static int answer = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}


		dfs( 0 );
		System.out.println(answer);



	}
	static void dfs ( int depth ){
		if( depth == 5 ){

			for( int i =0 ;i < n; i++ ){
				for( int j =0; j < n; j ++ )
					answer = Math.max( answer , arr[i][j] );
			}
			return;
		}

		int[][] temp = new int[n][n];
		for( int i=0; i < n ; i ++ )
			temp[i] = arr[i].clone();


		for( int i =0 ; i < 4; i ++ ){

			switch (i){
				case 0:
					moveUp();
					break;
				case 1:
					moveDown();
					break;
				case 2:
					moveLeft();
					break;
				case 3:
					moveRight();
					break;
			}

			dfs(depth+1);
			for (int j = 0; j < n; j++)
				arr[j] = temp[j].clone();
		}
	}

	static void moveUp (){
		boolean[][] visited = new boolean[n][n];

		for( int i=1 ; i < n;  i++ ){
			for( int j=0; j < n; j ++ ){

				// 현재 칸이 0 이라면 옮길 필요가 없다.
				if( arr[i][j] == 0 )
					continue;


				for( int k = i-1; k >= 0 ; k-- ){
					if( arr[k][j] == arr[k+1][j] &&  !visited[k][j] && !visited[k+1][j] ){
						arr[k][j] = arr[k+1][j]*2;
						arr[k+1][j] = 0;
						visited[k][j] = true;
					}
					else if( arr[k][j] == 0 ){
						arr[k][j] = arr[k+1][j];
						arr[k+1][j] = 0;
					}
					else break;

				}
			}
		}

	}
	static void moveDown(){

		boolean[][] visited = new boolean[n][n];

		for( int i=n-2 ; i >= 0 ;  i-- ){
			for( int j=0; j < n; j ++ ){
				if( arr[i][j] == 0 )
					continue;

				for( int k = i+1; k < n ; k++ ){
					if( arr[k][j] == arr[k-1][j]  &&  !visited[k][j] && !visited[k-1][j] ){
						arr[k][j] = arr[k-1][j]*2;
						arr[k-1][j] = 0;
						visited[k][j] = true;

					}
					else if( arr[k][j] == 0 ){
						arr[k][j] = arr[k-1][j];
						arr[k-1][j] = 0;
					}else break;

				}
			}
		}
	}
	static void moveLeft( ){
		boolean[][] visited = new boolean[n][n];

		for( int i=1; i < n; i++ ){
			for( int j=0; j < n; j ++ ){

				if( arr[j][i] == 0 )
					continue;

				for( int k = i-1; k >=0; k-- ){
					if( arr[j][k] == arr[j][k+1] && !visited[j][k]&& !visited[j][k+1] ){
						arr[j][k] = arr[j][k]*2;
						arr[j][k+1] = 0;
						visited[j][k] = true;
					}
					else if( arr[j][k] == 0 ){
						arr[j][k] = arr[j][k+1];
						arr[j][k+1] = 0;
					}else
						break;
				}

			}
		}
	}
	static void moveRight( ){
		boolean[][] visited = new boolean[n][n];


		for( int i= n-2 ; i >= 0 ; i-- ){
			for( int j=0; j < n; j ++ ){

				if( arr[j][i] == 0 )
					continue;


				for( int k = i+1; k < n ; k++ ){
					if( arr[j][k] == arr[j][k-1] && !visited[j][k] && !visited[j][k-1] ){
						arr[j][k] = arr[j][k]*2;
						arr[j][k-1] = 0;
						visited[j][k] = true;
					}
					else if( arr[j][k] == 0 ){
						arr[j][k] = arr[j][k-1];
						arr[j][k-1] = 0;
					}else
						break;
				}

			}
		}
	}
}
