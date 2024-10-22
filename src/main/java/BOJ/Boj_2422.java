package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2422 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean[][] arr = new boolean[n+1][n+1];

		for ( int i=0; i < m ;i++ ){
			st = new StringTokenizer(br.readLine());

			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());

			arr[first][second] = true;
			arr[second][first] = true;
		}

		int answer = 0;
		// true 면 불가능

		for ( int i=1; i <=n ;i++ ){
			for ( int j = i+1; j <=n ;j++ ){
				for ( int k = j+1; k <=n ; k++ ){
					System.out.println(i+" "+j+" "+k);
					int count = 0;
					if( arr[i][j] )
						count++;
					if (arr[j][k])
						count++;
					if (arr[i][k])
						count++;

					if ( count == 0 ) {
						answer++;
					}

				}
			}
		}

		System.out.println(answer);
	}

}
