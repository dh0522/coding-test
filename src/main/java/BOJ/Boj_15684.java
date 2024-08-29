package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15684 {
	static int n,m,h;
	static int[][] arr;
	static boolean poss = false;
	static int answer = -1;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		arr = new int[h][n];

		while ( m-- >0 ){
			st = new StringTokenizer( br.readLine() );
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;

			arr[a][b] = 2;
			arr[a][b+1] = -2;
		}

		for( int i=0 ; i< 4; i++ ){
			dfs( i , 0, 0 );
			if( poss ) {
				answer = i;
				break;
			}
		}

		System.out.println( answer );
	}
	private static void dfs( int max , int start , int depth ){

		if( max  == depth ){
			isAll();
			return;
		}

		for( int i = start; i < h ;i ++ ){
			for( int j = 0; j < n-1 ; j++ ){
				if( arr[i][j] == 0 && arr[i][j+1] == 0 ) {

					arr[i][j] = 2;
					arr[i][j + 1] = -2;

					dfs(max, i, depth + 1);

					arr[i][j] = 0;
					arr[i][j + 1] = 0;
				}
			}
		}

	}
	private static void isAll(){

		for( int i = 0; i < n; i++ ){
			int start = i;// n번째 세로선
			int garo = 0; // 가로는 항상 0부터 시작

			for( int j =0 ; j < h; j++) {
				if( arr[garo][start] == 2 ){
					start++;
				}else if( arr[garo][start] == -2 ){
					start--;
				}
				garo++;
			}

			if( start != i )
				return;

		}
		poss = true;
	}


}














