package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7569 {
	static int[] dx = { 1, 0, -1, 0 ,0 , 0};
	static int[] dy = { 0, 1, 0, -1 ,0 , 0};
	static int[] dz =  { 0, 0 ,0, 0, 1, -1};
	static int[][][] box;
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// m = 상자 가로 칸의 수 , n = 상자 세로 칸의 수 , H = 상자의 수
		int m =Integer.parseInt(st.nextToken());
		int n =Integer.parseInt(st.nextToken());
		int h =Integer.parseInt(st.nextToken());


		box = new int[n][m][h];

		for( int k = 0 ; k < h ; k++ ){
			for( int i = 0; i < n ; i++ ){
				st = new StringTokenizer(br.readLine());
				for( int j = 0; j< m ; j++ ){
					box[i][j][k] =Integer.parseInt(st.nextToken());
					if( box[i][j][k] == 1 ){
						q.add( new int[]{i,j,k} );
					}
				}
			}

		}

		System.out.println(bfs(n,m,h));

	}
	public static int bfs(int n, int m , int h){

		int max = 0;
		while( !q.isEmpty() ){

			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			int z = now[2];

			for( int i =0 ;i < 6; i++ ){

				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];

				if( nx < 0 || ny < 0 || nz < 0 || nx >= n || ny >=m || nz >= h )
					continue;

				if( box[nx][ny][nz] == 0 ){
					box[nx][ny][nz] = box[x][y][z] + 1;
					max = box[nx][ny][nz];
					q.add( new int[] {nx,ny,nz});
				}
			}

		}

		for( int k= 0; k< h;k ++ ){
			for( int i  =0 ; i< n ;i++ ){
				for( int j= 0 ; j < m ; j++ ){
					if( box[i][j][k] == 0 )
						return -1;
				}

			}

		}

		if( max == 0 )
			return max;
		else return max-1;

	}



}
