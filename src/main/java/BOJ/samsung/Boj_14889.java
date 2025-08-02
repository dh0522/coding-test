package BOJ.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14889 {
	private static int ans = Integer.MAX_VALUE;
	static boolean[] check;
	static int[][] arr;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		for (int i = 0; i < n; i++ ){
			st = new StringTokenizer(br.readLine());
			for(int j =0; j < n; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		check = new boolean[n];
			//  sum.depth
		dfs(0, 0,  n);


		System.out.println(ans);

	}
	private static void dfs(int depth, int idx,  int n){
		if (depth == n/2){
			searchMin(n);
			return;
		}

		for (int i = idx; i < n; i++ ){
			if (check[i])
				continue;

			check[i] = true;
			dfs(depth+1, i, n);
			check[i] = false;
		}

	}
	private static void searchMin(int n){
		int sum1 = 0;
		int sum2 = 0;

		for(int i =0; i < n; i++){
			for (int j =0; j < n; j++){
				if ( check[i] && check[j] ){
					sum1 += arr[i][j];
				}else if( !check[i] && !check[j]  ){
					sum2 += arr[i][j];
				}
			}
		}

		ans = Math.min(ans, Math.abs(sum1-sum2) );

	}
}
