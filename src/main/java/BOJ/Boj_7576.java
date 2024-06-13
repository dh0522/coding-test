package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7576 {
	static int[][] box;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static Queue<int[]> q = new LinkedList<int[]>();
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		box = new int[n][m];

		for( int i =0 ;i < n; i++ ){
			st = new StringTokenizer(br.readLine());
			for( int j =0; j< m; j++ ){
				box[i][j] = Integer.parseInt(st.nextToken());
				if( box[i][j] == 1 ){
					q.add( new int[]{i,j} );
				}
			}
		}

		afterDay();


	}
	public static void afterDay (){

		int day = 0;

		while( !q.isEmpty() ){

			int[] now = q.poll();
			int x = now[0];
			int y = now[1];

			for( int k =0 ; k < 4; k ++ ){

				int nx = x + dx[k];
				int ny = y + dy[k];

				if( nx < 0 || ny < 0 || nx >= box.length || ny >= box[0].length || box[nx][ny] == -1)
					continue;

				if( box[nx][ny] == 0 ){
					box[nx][ny] = box[x][y] + 1;
					day = box[nx][ny];
					q.add(new int[]{nx,ny});
				}


			}
		}

		if( allZero() ){
			if( day == 0 )
				System.out.println( day );
			else
				System.out.println(day-1);
		}else
			System.out.println(-1);

	}
	public static boolean allZero(){
		for( int i =0 ; i < box.length; i++ ){
			for( int j  =0 ; j< box[0].length ;j ++ ){

				if( box[i][j] == 0 )
					return false;

			}
		}
		return true;
	}

}
