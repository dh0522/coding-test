package coding_study.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14889 {
	static int diff = Integer.MAX_VALUE;
	static boolean[] check;
	public static void main(String[] args) throws Exception {

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] power = new int[n][n];

		check = new boolean[n];
		for (int i = 0; i< n; i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++ ){
				power[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		searchDiff(0, 0, power, n );
		System.out.println(diff);


	}
	private static void searchDiff(int now, int count, int[][] power, int n ){
		if ( count == n/2 ){

			int sumA = 0;
			int sumB = 0;

			for (int i = 0; i < power.length; i++ ){
				for ( int j = 0;j < power.length; j++ ){

					if (check[i] && check[j]){
						sumA += power[i][j];
					}
					else if( !check[i] && !check[j] ){
						sumB += power[i][j];
					}
				}
			}

			diff = Math.min( diff, Math.abs(sumA-sumB) );
			return;

		}


		for (int i = now; i < n; i++ ){
			if (check[i])
				continue;
			check[i] = true;
			searchDiff( i, count+1, power, n );
			check[i] = false;
		}
	}
}
