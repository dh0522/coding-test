package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15684 {
	static int n,m,h;
	static boolean possible;
	static int[][] line;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		line = new int[h][n];

		for( int i=0; i< m; i++ ){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) -1;
			int b = Integer.parseInt(st.nextToken()) -1;

			/// n == b번 세로선 b+1번 세로선 연결
			// h == a번 점선위치에서 연결

			line[a][b] = 1;
			line[a][b+1] = 2;
		}

		int answer = -1;

		for( int i =0; i< 4; i++ ){

			dfs( i, 0,0);

			if( possible ){
				answer = i;
				break;
			}
		}
		System.out.println(answer);

	}

	/**
	 * 	점선을 새로 연결하기
	 */
	private static void dfs( int newNum , int x , int depth ){

		if( newNum == depth ) {
			if( isRight() )
				possible = true;
			return;
		}


		for( int i = x ; i < h ;i++ ){

			for( int j = 0 ; j < n-1  ; j++ ){

				if( line[i][j] == 0 && line[i][j+1] == 0 ) {

					line[i][j] = 1;
					line[i][j + 1] = 2;
					dfs( newNum , i, depth + 1);
					line[i][j] = 0;
					line[i][j + 1] = 0;
				}
			}
		}

	}
	/**
	 *   i 가 i 로 도착하는지 확인
	 *   => true : 모두 잘 도착
	 *   => false : 아님
	 */
	private static boolean isRight(){

		for( int i =0; i< n; i++ ){

			int x = 0; // 높이가 0 => 시작점
			int y = i; // 세로선 n을 의미함

			for( int j = 0; j < h; j++ ){

				if( line[x][y] == 1 ){
					y++;
				}else if( line[x][y] == 2 ){
					y--;
				}
				x++;

			}

			if( y != i )
				return false;


		}

		return true;
	}
}
