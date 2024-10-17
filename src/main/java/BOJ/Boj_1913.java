package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_1913 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][n];
		int[] dx= {-1,0,1,0};
		int[] dy ={0,1,0,-1};

		int[] answer = new int[2];
		int x = n/2;
		int y = n/2;

		int dir = 0;
		int count = 1;

		while( true ){

			if( count == m ){
				answer[0] = x+1;
				answer[1] = y+1;
			}

			arr[x][y] = count++;

			if ( count == n*n+1 )
				break;

			int tempX = x + dx[(dir+1)%4];
			int tempY = y + dy[(dir+1)%4];

			if ( count == 2 ){
				x += dx[dir];
				y += dy[dir];
				continue;
			}

			if ( arr[tempX][tempY] == 0 ){
				dir = (dir+1)%4;
				x = tempX;
				y = tempY;

			}else{
				x += dx[dir];
				y += dy[dir];
			}


		}


		StringBuilder sb = new StringBuilder();
		for ( int i=0; i < n; i++ ){
			for ( int j=0; j< n; j++ ) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		sb.append(answer[0]).append(" ").append(answer[1]);
		System.out.println(sb);

	}
}
