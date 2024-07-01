package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_6593 {
	static int[] dx = { 0, 0, 1, 0, -1, 0 };
	static int[] dy = { 0, 0, 0, 1, 0, -1 };
	static int[] dh = { 1, -1, 0, 0, 0, 0 };
	static int time = 0;
	static int l,r,c;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while ( true ){

			StringTokenizer st = new StringTokenizer(br.readLine());

			l = Integer.parseInt( st.nextToken() );
			r = Integer.parseInt( st.nextToken() );
			c = Integer.parseInt( st.nextToken() );

			if( l == 0 && r == 0 && c == 0 )
				break;

			int[][][] visited = new int[l][r][c];
			char[][][] building = new char[l][r][c];
			int x = 0 , y= 0 , h = 0;

			for(int i = 0; i < l ; i++ ){
				for( int j = 0; j < r; j++ ){
					String now = br.readLine();
					for( int k = 0 ; k < c ; k++ ){
						building[i][j][k] = now.charAt(k);
						if( building[i][j][k] == 'S' ){
							h = i;
							x = j;
							y = k;
						}
					}
				}
				br.readLine();
			}
			if( escape( visited , building , x,y, h ) ){
				sb.append("Escaped in "+time +" minute(s).\n");
			}
			else sb.append("Trapped!\n");
		}
		System.out.println(sb);
	}
	private static boolean escape( int[][][] visited ,char[][][] building , int x , int y , int h ){

		Queue<int[]> q = new LinkedList<>();

		q.add(new int[]{h,x,y});
		visited[h][x][y] = 1;

		while( ! q.isEmpty() ){

			int[] now = q.poll();
			h = now[0];
			x = now[1];
			y = now[2];

			if( building[h][x][y] == 'E' ){
				time = visited[h][x][y]-1;
				return true;
			}

			for( int i =0; i < 6; i++ ){
				int nh = h + dh[i];
				int nx = x + dx[i];
				int ny = y + dy[i];

				if( nx < 0 || ny < 0 || nh < 0 || nh >= l || nx >= r || ny >= c )
					continue;

				if( building[nh][nx][ny] == '#' || visited[nh][nx][ny] != 0 )
					continue;

				visited[nh][nx][ny] = visited[h][x][y] + 1;
				q.add(new int[]{nh,nx,ny});

			}
		}
		return false;
	}
}
