package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_4396 {
	static int[] dx = {0,1,0,-1,-1,-1,1,1};
	static int[] dy = {1,0,-1,0,-1,1,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		char[][] arr = new char[n][n];

		for (int i=0; i < n; i++ ){
			String temp = br.readLine();
			arr[i] = temp.toCharArray();
		}

		boolean bomb = false;
		char[][] user = new char[n][n];
		for ( int i=0; i < n; i++ ){
			String temp = br.readLine();
			for ( int j =0; j < n ;j ++ ){
				user[i][j] = temp.charAt(j);
				if ( user[i][j] == 'x' && arr[i][j] == '*' ){
					bomb = true;
				}
			}
		}


		String[][] answer = new String[n][n];
		for ( int i=0; i < n ;i++ ){
			for ( int j=0; j <n ;j++ ){

				if (bomb && arr[i][j] == '*' )
					answer[i][j] = "*";
				else if ( user[i][j] == 'x' ){
					int count = 0;
					for ( int d= 0; d < 8; d++ ){
						int nx = i + dx[d];
						int ny = j + dy[d];

						if ( nx < 0 || ny <0 || nx >= n || ny >= n )
							continue;

						if ( arr[nx][ny]  == '*' )
							count++;
					}

					answer[i][j] = count+"";
				}
				else
					answer[i][j] = ".";

			}
		}

		for ( int i=0 ; i <n; i++ ){
			for ( int j=0; j < n; j++ ){
				System.out.print(answer[i][j]);
			}
			System.out.println();
		}

	}
}
