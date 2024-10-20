package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2615 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] arr = new int[19][19];

		int[] dx = {1,0,1,1};
		int[] dy = {0,1,1,-1};

		for ( int i=0;i < 19; i++ ){
			st = new StringTokenizer(br.readLine());
			for ( int j=0;j < 19; j++ ){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for ( int j =0 ; j< 19; j++ ){
			for ( int i=0; i < 19; i++ ){

				if ( arr[i][j] == 0 )
					continue;

				int dir = -1 ;
				int nowStone = arr[i][j];

				for ( int d = 0; d< 4; d++ ){

					int nx = i + dx[d];
					int ny = j + dy[d];

					if ( nx < 0 || ny < 0 || nx >= 19 || ny >= 19 )
						continue;
					if ( arr[nx][ny] == nowStone ){
						dir = d;
						break;
					}
				}
				if ( dir == -1 )
					continue;

				int x = i;
				int y = j;

				int count = 0 ;
				while( arr[x][y] == nowStone ) {
					count++;
					x += dx[dir];
					y += dy[dir];

					if ( x < 0 || y < 0 || x >= 19 || y >= 19 )
						break;
				}

				int exX = i - dx[dir];
				int exY = j - dy[dir];
				if( exX >= 0 && exX< 19 && exY >=0 && exY < 19 && arr[exX][exY] == nowStone ){
					continue;
				}

				if ( count == 5 ){
					if( dir == 3 ){

						i = x - dx[dir];
						j = y - dy[dir];

					}
					System.out.println( arr[i][j] );
					System.out.println( (i+1)+" "+ (j+1) );
					return;
				}



			}
		}

		System.out.println(0);



	}

}
