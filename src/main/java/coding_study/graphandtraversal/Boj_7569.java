package coding_study.graphandtraversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7569 {
	static int[][][] box;
	static int[] dx = {1,-1,0,0,0,0};
	static int[] dy = {0,0,1,-1,0,0};
	static int[] dh = {0,0,0,0,1,-1};
	static Queue<int[]> tomato = new ArrayDeque<>();
	static int[][][] check;
	static int m,n,h;
	static int zeroCount = 0;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		box = new int[h][n][m];
		check = new int[h][n][m];

		for( int i = 0; i < h; i++ ){
			for( int j = 0; j < n; j++ ){
				st = new StringTokenizer(br.readLine());

				for (int k=0; k < m ; k++ ){
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if ( box[i][j][k] == 0 )
						zeroCount++;
					else if( box[i][j][k] == 1 ){
						tomato.add(new int[]{i,j,k});
						check[i][j][k] = 1;
					}

				}
			}
		}

		if( zeroCount == 0 ){
			System.out.println(0);
			return;
		}

		System.out.println(bfs());

	}
	private static int bfs(){

		int day = 0;
		while( !tomato.isEmpty() ){
			int[] now = tomato.poll();

			for( int i = 0; i < 6; i++ ){
				int nh = now[0] + dh[i];
				int nx = now[1] + dx[i];
				int ny = now[2] + dy[i];

				if( nh < 0 || nx < 0 || ny < 0 || nh >= box.length || nx >= box[0].length || ny >= box[0][0].length )
					continue;

				if( check[nh][nx][ny] != 0 )
					continue;

				if ( box[nh][nx][ny] == -1 )
					continue;

				check[nh][nx][ny] = check[now[0]][now[1]][now[2]] + 1;
				tomato.add( new int[]{nh,nx,ny} );
				day = Math.max( day , check[nh][nx][ny] );
				zeroCount--;
			}
		}

		if ( zeroCount == 0 ){
			return day-1;
		}
		return -1;



	}
}
