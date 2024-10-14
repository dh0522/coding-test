package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_11967 {
	static int n;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static ArrayList<Room>[][] arr;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new ArrayList[n][n];


		for ( int i =0; i <n ; i ++ ){
			for (int j = 0; j < n; j ++ )
				arr[i][j] = new ArrayList<>();
		}


		for (int i=0; i <m ; i++ ){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;

			arr[x][y].add( new Room(a,b) );
		}

		bfs();


	}
	private static void bfs() {

		Queue<Room> q = new LinkedList<>();
		q.add( new Room(0,0) );

		boolean[][] visited = new boolean[n][n];
		visited[0][0] = true;
		boolean[][] light = new boolean[n][n];
		light[0][0] = true;

		boolean[][] move = new boolean[n][n];

		int answer = 1;

		while( !q.isEmpty() ){
			Room now = q.poll();

			for ( int i =0; i < 4; i++ ){
				int nx = now.x+ dx[i];
				int ny = now.y+ dy[i];

				if ( nx < 0 || ny < 0 || nx >=n || ny >= n )
					continue;

				move[nx][ny] = true;
			}

			for ( int i=0; i < arr[now.x][now.y].size(); i++ ){
				Room temp = arr[now.x][now.y].get(i);

				//불이 꺼져있다면 -> 켜주기
				if( !light[temp.x][temp.y] ){
					light[temp.x][temp.y] = true;
					answer++;
				}

				if( move[temp.x][temp.y] ){
					q.add( temp );
					visited[temp.x][temp.y] = true;
				}
			}
			for ( int i=0; i < 4; i++ ){
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if ( nx < 0 || ny < 0 || nx >=n || ny >= n )
					continue;

				if ( !light[nx][ny] || !move[nx][ny] || visited[nx][ny] )
					continue;

				visited[nx][ny] = true;
				q.add( new Room(nx,ny) );

			}

		}
		System.out.println(answer);
		return;


	}
	static class Room {
		int x,y;
		public Room( int x , int y  ){
			this.x = x;
			this.y = y;
		}
	}
}
