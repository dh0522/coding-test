package coding_study.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1149 {
	public static void main(String[] args) throws Exception {

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][3];

		for ( int i = 0 ; i < n; i ++ ){
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if ( i == 0 ){
				arr[i][0] = r;
				arr[i][1] = g;
				arr[i][2] = b;
				continue;
			}

			arr[i][0] = Math.min( arr[i-1][1] + r , arr[i-1][2] + r );
			arr[i][1] = Math.min(arr[i-1][0] + g, arr[i-1][2] + g );
			arr[i][2] = Math.min(arr[i-1][0] + b, arr[i-1][1] + b );

		}

		System.out.println(Math.min(arr[n-1][0], Math.min(arr[n-1][1], arr[n-1][2] )));
	}
}
