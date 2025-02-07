package coding_study.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_9663 {
	static int[][] visited;
	static int answer = 0;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// n 이 주어졌을 때, 퀸 N개를 서로 공격할 수 없게 놓는 경우

		visited = new int[n][n];
		nQueen(0, n);

		System.out.println(answer);
	}
	private static void nQueen(int now, int n){

		if (now == n){
			answer++;
			return;
		}

		for (int i = 0; i < n; i++){
			if ( visited[now][i] == 0 ){
				goQueen( now, i, 1 );
				nQueen(now+1, n);
				goQueen( now, i, -1 );
			}
		}
	}
	private static void goQueen( int row, int column, int num){

		// 같은 행 배치
		for (int i = 0; i < visited.length; i++ ){
			visited[row][i] += num;
		}

		for ( int i = 1; i < visited.length - row; i++ ){
			// 같은 열 배치
			visited[row+i][column] += num;

			// 왼쪽 아래 배치
			// if( x = 3, y = 3) -> 4, 2 | 5,1
			if ( column - i >= 0){
				visited[row+i][column-i] += num;
			}

			// 오른쪽 아래 배치
			if ( column + i < visited.length ){
				visited[row+i][column+i] += num;
			}

		}

		visited[row][column] += num;

	}
}
