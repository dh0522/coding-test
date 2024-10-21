package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2615 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] arr = new int[19][19];

		int[] dx = {1,0,1,-1};
		int[] dy = {0,1,1,1};

		// 세로 부터 해.
		for( int i=0; i < 19; i++ ){
			st = new StringTokenizer(br.readLine());
			for ( int j=0; j < 19; j ++ ){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		for( int i=0; i < 19; i++ ){
			for( int j= 0; j < 19; j ++ ){

				if( arr[j][i] == 0 )
					continue;

				for( int d =0; d < 4; d ++ ){

					int nx = j + dx[d];
					int ny = i + dy[d];

					if( nx < 0 || ny <0 || nx >= 19 || ny >= 19 || arr[nx][ny] != arr[j][i] )
						continue;

					int count = 2;

					while( true ){
						nx += dx[d];
						ny += dy[d];

						if( nx < 0 || ny < 0 || nx >= 19 || ny >= 19 )
							break;

						if ( arr[nx][ny] == arr[j][i] )
							count++;
						else break;
					}

					int exX = j-dx[d];
					int exY = i-dy[d];
					
					boolean check = false;

					if ( 0 <= exX && exX < 19 && 0 <= exY && exY < 19 ){
						if ( arr[exX][exY] == arr[j][i] )
							check = true;
					}

					if ( check )
						break;

					if( count == 5 ){

						System.out.println( arr[j][i] );
						System.out.println((j+1)+" "+(i+1));
						return;
					}

					}

				}

		}

		System.out.println(0);


	}

}
