package programmers.level3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Prg_67259 {

	public static void main(String[] args) {
		Prg_67259 sol = new Prg_67259();
		System.out.println(sol.solution(new int[][] {{ 0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0 }}));
	}

	private int solution(int[][] board) {

		int n = board.length;

		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};

		int[][] cost = new int[n][n];
		for(int i =0; i < n; i++){
			Arrays.fill(cost[i], Integer.MAX_VALUE);
		}

		cost[n-1][n-1] = 0;

		Queue<Road> q = new LinkedList<>();
		q.add(new Road(n-1,n-1,-1,0));

		while(!q.isEmpty()){
			Road now = q.poll();

			for(int d = 0; d < 4; d++){
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];
				int dir = now.dir;
				int sum = now.sum;

				if(nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;

				if(board[nx][ny] == 1)
					continue;

				int addPrice = 0;

				if(dir == d || dir == -1){
					// 직선도로 -> + 100
					addPrice = 100;
				}else{
					addPrice = 100 + 500;
				}

				if(cost[nx][ny] < sum + addPrice)
					continue;

				cost[nx][ny] = sum + addPrice;
				q.add(new Road(nx, ny, d, cost[nx][ny]));
			}

		}

		return cost[0][0];
	}
}
class Road{
	int x;
	int y;
	int dir;
	int sum;
	public Road(int x, int y, int dir, int sum){
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.sum = sum;
	}
}
