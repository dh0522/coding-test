package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14499 {
	static int n,m,x,y,k;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int[] dice;
	public static void main(String[] args) throws  Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());


		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for( int i=0 ; i < n ; i++ ){
			st = new StringTokenizer(br.readLine());
			for( int j=0 ; j< m ; j++ ){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dice = new int[6];
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		for( int i=0 ; i < k ; i++ ){
			int dir = Integer.parseInt(st.nextToken());

			if( !isPossible( dir-1 ) )
				continue;

			move( dir );
			if( map[x][y] == 0 ){
				map[x][y] = dice[3];

			}else{
				dice[3] = map[x][y];
				map[x][y] = 0;
			}
			sb.append( dice[1] +"\n");
		}

		System.out.println(sb.toString());

	}
	private static boolean isPossible( int dir ){

		int nx = x + dx[dir];
		int ny = y + dy[dir];

		if( nx < 0 || ny < 0 || nx >= n || ny >= m )
			return false;

		x = nx;
		y = ny;
		return true;
	}
	private static void move( int d ){
		int tmp = dice[1];
		switch (d){
			case 1:
				dice[1] = dice[4];
				dice[4] = dice[3];
				dice[3] = dice[5];
				dice[5] = tmp;
				break;

			case 2:
				dice[1] = dice[5];
				dice[5] = dice[3];
				dice[3] = dice[4];
				dice[4] = tmp;
				break;

			case 3:
				dice[1]= dice[2];
				dice[2] = dice[3];
				dice[3] = dice[0];
				dice[0] = tmp;
				break;

			case 4:
				dice[1] = dice[0];
				dice[0] = dice[3];
				dice[3] = dice[2];
				dice[2] = tmp;
				break;
		}

	}
}
