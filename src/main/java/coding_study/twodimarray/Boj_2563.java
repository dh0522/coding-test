package coding_study.twodimarray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2563 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int x = 0, y = 0;

		boolean[][] wall = new boolean[100][100];
		int sum = 0 ;

		for ( int k =0; k < n ; k++ ){
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			for (int i = x; i < x + 10; i++ ) {
				for ( int j = y ; j < y + 10; j++ ){
					if (wall[i][j])
						continue;
					sum++;
					wall[i][j] = true;
				}
			}

		}

		System.out.println(sum);

	}
}
