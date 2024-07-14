package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_3190 {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int n, k;
	static int[][] board;
	static int nowTime = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		board = new int[n][n];

		/**
		 * 		board[i][j] == 0 : 아무것도 없는 그냥 길
		 * 		board[i][j] == 2 : 사과의 위치
		 *
		 */

		StringTokenizer st;
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;

			board[x][y] = 2;
		}

		int l = Integer.parseInt(br.readLine());
		int[] time = new int[l];
		String[] dir = new String[l];

		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			dir[i] = st.nextToken();
		}

		dummy(time, dir);
		System.out.println(nowTime);

	}

	private static void dummy(int[] time, String[] dir) {

		List<int[]> list = new ArrayList<>();
		list.add(new int[] {0, 0});
		int x = 0;
		int y = 0;

		int idx = 0;
		int d = 0;

		while (true) {


			if (idx < time.length && nowTime == time[idx]) {
				if (dir[idx].equals( "L" ) )
					d = d - 1 >= 0 ? d - 1 : 3;
				else
					d = d + 1 == 4 ? 0 : d + 1;
				idx++;
			}


			x += dx[d];
			y += dy[d];
			nowTime++;

			if( !isPossible(x,y, list ) )
				return;

			if (board[x][y] != 2) {
				list.remove(0);
			}else{
				board[x][y] = 0;
			}

			list.add(new int[] {x, y});

		}
	}
	private static boolean isPossible( int x ,  int y , List<int[]> list ){
		if (x < 0 || y < 0 || x >= n || y >= n )
			return false;

		for( int i = 0 ; i < list.size(); i++ ){
			if( x == list.get(i)[0] && y == list.get(i)[1] ){
				return false;
			}
		}
		return true;
	}

}
