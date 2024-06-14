package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7576 {
	static int[][] box;
	static int[] dx = { 1, 0, -1, 0};
	static int[] dy = { 0, 1, 0, -1};
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt( st.nextToken() );
		int n = Integer.parseInt( st.nextToken() );

		box = new int[n][m];
		for( int i= 0; i< n ; i++ ){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j< m; j ++ ){
				box[i][j] = Integer.parseInt(st.nextToken());
				if( box[i][j] == 1 ){
					q.add(new int[]{i,j} );
				}
			}
		}


		System.out.println(bfs());

	}
	public static int bfs(){

		int max = 0;

		while( !q.isEmpty() ){

			int[] now = q.poll();
			int x = now[0];
			int y = now[1];

			for( int i =0 ;i < 4; i++ ){
				int nx = x + dx[i];
				int ny = y + dy[i];

				if( nx < 0 || ny < 0 || nx >= box.length || ny >= box[0].length )
					continue;

				if( box[nx][ny] == 0 ){
					box[nx][ny] = box[x][y] + 1;
					max = box[nx][ny];

					q.add( new int[] {nx,ny} );

				}
			}



		}

		for( int i = 0 ; i< box.length; i++ ){
			for( int j = 0 ;j < box[0].length ; j++ ){
				if( box[i][j]  == 0 )
					return -1;
			}
		}
		if( max == 0 )
			return 0;
		return max-1;


	}



}


