package BOJ.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15684 {
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// n 개의 세로선 ,
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int[][] arr = new int[h][n];

		for (int i = 0; i < m; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;

			arr[a][b] = 1; // 1이라면 (b,b+1)이 연결
			arr[a][b+1] = -1; // -1이라면 (b-1,b) 연결
		}



		if(isPossible(arr)){
			System.out.println(0);
			return;
		}

		dfs(0, arr, 0);

		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

	}
	private static void dfs(int depth, int[][] arr, int x){
		if (depth == 4 || depth >= answer) {
			return;
		}

		if( isPossible(arr) ){
			answer = Math.min(answer, depth);
		}

		for (int i = x; i < arr.length; i++){
			for (int j = 0; j < arr[0].length -1 ; j++){
				if (arr[i][j] == 0 && arr[i][j+1] == 0){


					arr[i][j] = 1;
					arr[i][j+1] = -1;

					dfs(depth+1, arr, i);

					arr[i][j] = 0;
					arr[i][j+1] = 0;

				}
			}
		}

	}

	private static boolean isPossible(int[][] arr){

		for (int i = 0; i < arr[0].length; i++){
			int one = i;

			for (int j = 0; j < arr.length; j++){
				if (arr[j][one] == 1){
					one++;
				}else if(arr[j][one] == -1){
					one--;
				}
			}

			if (one!= i)
				return false;

		}

		return true;
	}
}
