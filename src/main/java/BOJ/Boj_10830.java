package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10830 {
	static int[][] origin;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		origin = new int[n][n];
		for (int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++){
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		StringBuilder sb = new StringBuilder();

		if (b == 1){
			for (int i = 0; i < n; i++){
				for (int j = 0; j  < n ;j++){
					sb.append(origin[i][j]%1000).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			return;
		}

		int[][] arr = origin.clone();
		arr = memoization(arr, b);

		// 출력
		for (int i = 0; i < n; i++){
			for (int j = 0; j  < n ;j++){
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int[][] memoization(int[][] arr, long b){
		if (b <= 1)
			return arr;

		arr = memoization(arr, b/2);

		if (b % 2 == 0){
			arr = pow(arr, arr);
		}
		else{
			arr = pow(pow(arr,arr), origin);
		}
		return arr;

	}
	private static int[][] pow(int[][] origin, int[][] arr){
		int n = origin.length;
		int[][] temp = new int[n][n];

		for (int x = 0; x < n; x++){
			for (int y = 0; y < n; y++){
				temp[x][y] = multiple(origin, arr, n, x, y );
			}
		}


		return temp;
	}
	private static int multiple(int[][] origin, int[][] arr, int n, int x, int y){

		int num = 0;

		for (int i = 0; i < n; i++){
			num += origin[x][i]*arr[i][y];
		}

		return num%1000;
	}
}
