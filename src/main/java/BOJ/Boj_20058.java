package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_20058 {
	static int num,q;
	static int[][] arr;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][] visited;
	static int maxSize = 0;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine() );

		int n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());

		num = (int) Math.pow(2,n);

		arr = new int[num][num];

		for( int i =0;i <num; i++ ){
			 st = new StringTokenizer(br.readLine());
			 for( int j=0; j< num ;j++ )
				 arr[i][j] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		for( int i =0; i < q; i++ ){
			int level = Integer.parseInt(st.nextToken());
			level = (int) Math.pow( 2, level );

			for( int x = 0; x < num; x+= level ){
				for( int y = 0; y < num; y+= level )
					turn( x , y , level );
			}
			reduceIce();
		}

		visited = new boolean[num][num];
		int iceSum = 0;

		for( int i= 0; i < num; i++ ){
			for( int j=0; j< num ;j++ ){
				iceSum += arr[i][j];
				if( !visited[i][j] && arr[i][j] != 0 )
					bfs(i,j);

			}
		}

		System.out.println(iceSum +"\n" + maxSize );

	}
	private static void reduceIce(){

		int[][] tmp = new int[num][num];

		for( int i=0; i< num; i++ )
			tmp[i] = arr[i].clone();

		for( int x = 0; x <num; x ++ ){
			for( int y =0; y < num; y++ ){

				if( tmp[x][y] == 0 )
					continue;

				int yesIce = 0;

				for( int d = 0; d < 4; d++ ){
					int nx = x + dx[d];
					int ny = y + dy[d];

					if( nx < 0 || ny < 0 || nx >= num || ny >= num )
						continue;

					if( arr[nx][ny] > 0  )
						yesIce++;
				}
				if( yesIce < 3 )
					tmp[x][y]--;
			}
		}
		arr = tmp;
	}

	private static void bfs( int x , int y ){

		visited[x][y] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add( new int[]{x,y} );
		int size = 1;

		while( !q.isEmpty() ){
			int[] now = q.poll();

			for( int i = 0; i < 4; i++ ){
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];

				if( nx < 0 || ny < 0 || nx >= num || ny >= num )
					continue;
				if( visited[nx][ny]  )
					continue;
				if( arr[nx][ny] == 0 )
					continue;

				visited[nx][ny] = true;
				q.add( new int[]{ nx,ny });
				size ++;
			}
		}


		maxSize = Math.max( maxSize, size );

	}
	private static void turn( int x , int y , int level ){

		int[][] tmp = new int[level][level];
		for( int i=0; i< level; i++ ){
			for( int j=0; j< level; j ++ )
				tmp[i][j] = arr[x+level-1-j][y+i];
		}

		for( int i=0;i < level; i++ ){
			for( int j=0; j< level; j++ )
				arr[x+i][y+j] = tmp[i][j];
		}


	}
}
