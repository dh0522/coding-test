package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1149 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][3];

		StringTokenizer st = new StringTokenizer(br.readLine());

		arr[0][0] = Integer.parseInt(st.nextToken());
		arr[0][1] = Integer.parseInt(st.nextToken());
		arr[0][2] = Integer.parseInt(st.nextToken());

		for( int i=1; i < n ;i++ ){
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[i][0] = Math.min( arr[i-1][1] + r , arr[i-1][2] + r );
			arr[i][1] = Math.min( arr[i-1][0] + g , arr[i-1][2] + g );
			arr[i][2] = Math.min( arr[i-1][1] + b , arr[i-1][0] + b );
		}

		System.out.println(Math.min(arr[n-1][0] , Math.min(arr[n-1][1], arr[n-1][2] )) );
	}
}
