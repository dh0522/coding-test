package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_10026 {
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static String[][] picture;
	static boolean[][] visited1;
	static boolean[][] visited2;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		picture = new String[n][n];
		visited1 = new boolean[n][n];
		visited2 = new boolean[n][n];

		for( int i =0 ; i <n; i++ ){
			String temp = br.readLine();
			for( int j = 0 ; j < n; j++ ){
				picture[i][j] = temp.charAt(j)+"";
			}
		}
		int first = 0;
		int second = 0;

		for( int i = 0; i < n ; i++ ){
			for( int j = 0 ;j < n; j ++ ){
				if( !visited1[i][j] ){
					general( i, j );
					first++;
				}
				if( !visited2[i][j] ){
					nocolor( i, j );
					second++;
				}
			}
		}
		System.out.println(first +" "+ second );

	}
	public static void general( int x , int y ){

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{x,y});

		String now = picture[x][y];

		while( !q.isEmpty() ){

			int[] loc = q.poll();
			x = loc[0];
			y = loc[1];
			visited1[x][y] = true;

			for( int i = 0 ; i < 4; i ++ ){

				int nx = x + dx[i];
				int ny = y + dy[i];

				if( nx < 0 || ny < 0 || nx >= picture.length || ny >= picture.length )
					continue;

				if( !visited1[nx][ny] && now.equals(picture[nx][ny]) ){
					q.add( new int[]{nx,ny} );
					visited1[nx][ny] = true ;
				}
			}

		}

	}
	public static void nocolor( int x , int y ){
		Queue<int[]> q = new LinkedList<>();
		q.add( new int[]{x,y} );

		boolean no = false;

		String now = picture[x][y];
		if( now.equals("R") || now.equals("G") )
			no = true;


		while( !q.isEmpty() ){
			int[] loc = q.poll();

			x = loc[0];
			y = loc[1];
			visited2[x][y] = true;

			for( int d = 0 ; d < 4; d ++ ){
				int nx = x + dx[d];
				int ny = y + dy[d];

				if( nx < 0 || ny < 0 || nx >= picture.length || ny >= picture.length )
					continue;

				// 초록 빨강일때
				if( !visited2[nx][ny] ){

					if( no && (picture[nx][ny].equals("R") || picture[nx][ny].equals("G") ) ){
						visited2[nx][ny] = true;
						q.add(new int[]{nx,ny});


					}else if ( !no && picture[nx][ny].equals(now) ) {
						visited2[nx][ny] = true;
						q.add( new int[]{nx,ny});
					}

				}
			}
		}
	}
}
