package BOJ.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_15683 {
	static int n,m;
	static int[][] room;
	static List<int[]> cctvList = new ArrayList<>();
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 0 빈칸, 6 벽, 1~5 CCTV
		room = new int[n][m];


		for (int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++){
				room[i][j] = Integer.parseInt(st.nextToken());


				// 빈칸, 벽이 아니면 cctv
				if (room[i][j] != 0 && room[i][j] != 6) {
					cctvList.add(new int[]{i,j,room[i][j]});
				}

			}
		}


		// 일단 완전 탐색으로 dfs
		dfs(0, room );
		System.out.println(answer);
	}
	private static void dfs(int depth, int[][] tmpRoom){

		if (depth == cctvList.size()){
			searchMin(tmpRoom);
			return;
		}

		int x = cctvList.get(depth)[0];
		int y = cctvList.get(depth)[1];
		int num = cctvList.get(depth)[2];

		int[][] newRoom = new int[n][m];

		for (int i = 0; i < n; i++){
			newRoom[i] = tmpRoom[i].clone();
		}


		if (num == 1){
			// dir 4 방향

			for (int d = 0; d < 4; d++ ){
				one(x,y,d,tmpRoom);
				dfs(depth+1, tmpRoom);
				setTmpRoom(tmpRoom, newRoom);

			}

		}else if(num == 2){

			for (int d = 0; d < 2; d++){
				two(x,y,d, tmpRoom);
				dfs(depth+1, tmpRoom);
				setTmpRoom(tmpRoom, newRoom);

			}


		}else if(num == 3 ){

			for (int d = 0; d < 4; d++){
				three(x,y,d, tmpRoom);
				dfs(depth+1, tmpRoom);
				setTmpRoom(tmpRoom, newRoom);


			}


		}else if(num == 4){

			for (int d = 0; d < 4; d++){
				four(x,y,d,tmpRoom);
				dfs(depth+1, tmpRoom);
				setTmpRoom(tmpRoom, newRoom);


			}

		}else if (num == 5){
			// 완전 방향 1 개 밖에 없어
			five(x,y,tmpRoom);
			dfs(depth+1, tmpRoom);
			setTmpRoom(tmpRoom, newRoom);
		}



	}
	private static void setTmpRoom(int[][] tmpRoom, int[][] newRoom){
		for (int k = 0; k < n; k++){
			tmpRoom[k] = newRoom[k].clone();
		}
	}

	private static void one(int x, int y, int dir, int[][] tmpRoom){
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};

		while(true){
			x = x + dx[dir];
			y = y + dy[dir];

			if (x < 0 || x >= n || y < 0 || y >= m)
				break;

			if (tmpRoom[x][y] == 6)
				break;
			else if(tmpRoom[x][y] == 0)
				tmpRoom[x][y] = -1;
		}
	}

	private static void two(int x, int y, int dir, int[][] tmpRoom){

		one(x,y,dir,tmpRoom);
		one(x,y,dir+2,tmpRoom);
	}
	private static void three( int x, int y, int dir, int[][] tmpRoom){

		one(x,y,dir,tmpRoom);
		one(x,y,(dir+1)% 4,tmpRoom);
	}
	private static void four(int x,int y, int dir, int[][] tmpRoom){

		for (int i = 0; i < 3; i++){
			one(x,y,dir,tmpRoom);
			dir = (dir+1) % 4;
		}
	}

	private static void five(int x, int y, int[][] tmpRoom){

		for (int i = 0; i < 4; i++){
			one(x,y,i,tmpRoom);
		}
	}

	private static void searchMin(int[][] tmpRoom){

		int cnt = 0;

		for (int i = 0; i < n; i++){
			for (int j= 0; j < m; j++ ){

				if (tmpRoom[i][j] == 0)
					cnt++;
			}
		}

		answer = Math.min(cnt, answer);
	}
}
