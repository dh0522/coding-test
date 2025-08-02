package BOJ.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_12100 {
	static int[] dir = new int[5];
	static int[][] board;
	static int[][] tmpBoard;
	static int answer = 0;
	static int n;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		board = new int[n][n];
		tmpBoard = new int[n][n];
		StringTokenizer st;
		for (int i =0; i < n; i ++ ){
			st = new StringTokenizer(br.readLine());
			for (int j=0; j< n; j++ ){
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0);

		System.out.println(answer);

	}
	private static void dfs(int depth){
		if ( depth ==  5 ){
			for (int i =0; i < n; i++ )
				tmpBoard[i] = board[i].clone();


			for (int i =0; i < 5; i++ ){
				if (dir[i] == 0)
					moveLeft();
				else if(dir[i] == 1)
					moveRight();
				else if(dir[i] == 2)
					moveUp();
				else
					moveDown();
			}

			searchMax();
			return;
		}
		for (int i = 0; i < 4; i++ ){
			dir[depth] = i;
			dfs(depth+1);
		}

	}

	private static void moveLeft(){

		// 각 방향에 맞게 이동
		for (int i =0; i <n; i++){

			Queue<Integer> q = new LinkedList<>();

			int[] tmp = new int[n];
			int idx = 0;
			for (int j = 0; j < n; j++ ){
				if (tmpBoard[i][j] == 0)
					continue;

				if (q.isEmpty()){
					q.add(tmpBoard[i][j]);
				}
				else if ( q.peek() == tmpBoard[i][j]){
					tmp[idx++] = q.poll()*2;
				}else {
					tmp[idx++] = q.poll();
					q.add(tmpBoard[i][j]);
				}
			}

			if (!q.isEmpty())
				tmp[idx++] = q.poll();
			tmpBoard[i] = tmp.clone();

		}


	}
	private static void moveRight(){


		// 각 방향에 맞게 이동
		for (int i =0; i <n; i++){

			Queue<Integer> q = new LinkedList<>();

			int[] tmp = new int[n];
			int idx = 0;
			for (int j = n-1; j >=0 ; j-- ){
				if (tmpBoard[i][j] == 0)
					continue;

				if (q.isEmpty()){
					q.add(tmpBoard[i][j]);
				}
				else if ( q.peek() == tmpBoard[i][j]){
					tmp[idx++] = q.poll()*2;
				}else {
					tmp[idx++] = q.poll();
					q.add(tmpBoard[i][j]);
				}
			}

			if (!q.isEmpty())
				tmp[idx++] = q.poll();

			for (int j = n-1; j >=0; j--){
				tmpBoard[i][j] = tmp[n-j-1];
			}

		}


	}
	private static void moveDown(){

		for (int i =0; i <n; i++){

			Queue<Integer> q = new LinkedList<>();

			int[] tmp = new int[n];
			int idx = 0;
			for (int j = n-1; j >=0 ; j-- ){
				if (tmpBoard[j][i] == 0)
					continue;

				if (q.isEmpty()){
					q.add(tmpBoard[j][i]);
				}
				else if ( q.peek() == tmpBoard[j][i] ){
					tmp[idx++] = q.poll()*2;
				}else {
					tmp[idx++] = q.poll();
					q.add(tmpBoard[j][i] );
				}
			}

			if (!q.isEmpty())
				tmp[idx++] = q.poll();

			for (int j = n-1; j >=0; j--){
				tmpBoard[j][i] = tmp[n-1-j];
			}

		}



	}
	private static void moveUp(){

		for (int i =0; i <n; i++){

			Queue<Integer> q = new LinkedList<>();

			int[] tmp = new int[n];
			int idx = 0;
			for (int j = 0; j < n; j++ ){
				if (tmpBoard[j][i] == 0)
					continue;

				if (q.isEmpty()){
					q.add(tmpBoard[j][i]);
				}
				else if ( q.peek() == tmpBoard[j][i] ){
					tmp[idx++] = q.poll()*2;
				}else {
					tmp[idx++] = q.poll();
					q.add(tmpBoard[j][i] );
				}
			}

			if (!q.isEmpty())
				tmp[idx++] = q.poll();

			for (int j =0; j < n; j++){
				tmpBoard[j][i] = tmp[j];
			}

		}
	}
	private static void searchMax(){

		for (int i =0; i < n; i++ ){
			for (int j = 0; j < n; j++ ){
				answer = Math.max(tmpBoard[i][j], answer);
			}
		}

	}

}
