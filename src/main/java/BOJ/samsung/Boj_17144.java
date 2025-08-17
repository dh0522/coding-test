package BOJ.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_17144 {
	static int r,c,t;
	static int[][] arr;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int airRow = 0;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		arr = new int[r][c];
		for (int i = 0; i < r; i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j ++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (airRow == 0 && arr[i][j] == -1){
					airRow = i;
				}
			}
		}


		while(t-- > 0){
			// 1. 미세먼지 확산
			spreadDust();
			// 2. 공기청정기 작동
			airPurifier();

		}

		int answer = 0;
		for (int i = 0; i < r; i++){
			System.out.println(Arrays.toString(arr[i]));
			for (int j =0 ;j < c; j ++){
				answer+= arr[i][j];
			}
		}

		System.out.println(answer+2);
	}
	private static void airPurifier(){
		int first = airRow;

		//행 first 고정 + 열 0~ c-1
		// 열 c-1 고정 + first ~ 0
		// 행 0 고정 + 열 c-1 ~ 0
		// 열 0 고정 + 행 0 ~ first;
		for (int i = first-2; i >= 0; i-- ){
			arr[i+1][0] = arr[i][0];
		}

		for (int i = 0; i < c-1; i++){
			arr[0][i] = arr[0][i+1];
		}

		for (int i = 0; i < first; i++ ){
			arr[i][c-1] = arr[i+1][c-1];
		}

		for (int i = c-1; i > 1; i-- ){
			arr[first][i] = arr[first][i-1];
		}

		arr[first][1] = 0;

		int second = airRow+1;
		// 행 second 고정 + 열 0~ c-1
		// 열 c-1 고정 + second ~ r-1
		// 행 r-1 고정 + 열 c-1 ~ 0
		// 열 0 고정 +  행 r-1 ~ second

		for (int i = second+1; i < r-1; i++){
			arr[i][0] = arr[i+1][0];
		}

		for (int i = 0; i < c-1; i++){
			arr[r-1][i] = arr[r-1][i+1];
		}

		for (int i = r-1; i > second; i--){
			arr[i][c-1] = arr[i-1][c-1];
		}

		for (int i = c-1; i > 0; i-- ){
			arr[second][i] = arr[second][i-1];
		}

		arr[second][1] = 0;


	}
	private static void spreadDust(){
		int[][] tmp = new int[r][c];

		for (int i = 0; i < r; i++){
			for (int j = 0; j < c; j++){
				if (arr[i][j] == 0 )
					continue;

				int cnt = 0;
				for (int d = 0; d < 4; d++){
					int nx = i + dx[d];
					int ny = j + dy[d];

					if (nx < 0 || ny < 0 || nx >= r || ny >= c)
						continue;

					if (arr[nx][ny] == -1)
						continue;

					cnt++;
				}

				for (int d = 0 ; d < 4; d++ ){
					int nx = i + dx[d];
					int ny = j + dy[d];

					if (nx < 0 || ny < 0 || nx >= r || ny >= c)
						continue;

					if (arr[nx][ny] == -1)
						continue;

					tmp[nx][ny] += arr[i][j]/5;
				}

				tmp[i][j] += (arr[i][j] - arr[i][j]/5*cnt);
			}

		}

		for (int i = 0; i < r; i++){
			arr[i] = tmp[i].clone();
		}
	}
}
