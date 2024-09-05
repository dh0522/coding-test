package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_17780 {
	static int n,k;
	static int[][] arr;
	static List<Integer>[][] all;
	static List<Horse> list = new ArrayList<>();
	static boolean no = false;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[n][n];
		all = new ArrayList[n][n];

		for( int i=0 ; i< n ;i++ ){
			st = new StringTokenizer(br.readLine());
			for( int j=0; j < n ;j ++ ) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				all[i][j] = new ArrayList<>();
			}
		}

		for( int i=0; i < k ;i++ ){
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken())-1;


			all[x][y].add(i);
			list.add( new Horse(x,y,dir) );
		}

		int turn = 0;

		while( !no && turn < 1000 ){

			for( int i=0; i <k ; i++ ){
				if( no )
					break;

				Horse horse = list.get(i);
				int d = horse.dir;

				if( all[horse.x][horse.y].isEmpty() || i != all[horse.x][horse.y].get(0) )
					continue;

				int nx = horse.x + dx[d];
				int ny = horse.y + dy[d];

				// nx , ny 새로운 칸
				if( nx < 0 || ny < 0 || nx >=n || ny >= n || arr[nx][ny] == 2 ){

					int newDir = -1;
					if( d == 0 )	newDir = 1;
					else if( d == 1 ) 	newDir = 0;
					else if( d== 2 ) 	newDir = 3;
					else if( d == 3 ) 	newDir = 2;

					horse.dir = newDir;
					list.get(i).dir = newDir;

					nx = horse.x + dx[newDir];
					ny = horse.y + dy[newDir];


					if( nx < 0 || ny < 0 || nx >=n || ny >= n || arr[nx][ny] == 2 ){
						continue;
					}
				}

				if( arr[nx][ny] == 0 ){
					white( horse );
				 }else if( arr[nx][ny] == 1 ){
					red( horse );
				}
			}

			turn++;
		}

		System.out.println( turn == 1000 ? -1 :  turn );

	}
	static void white( Horse now ){

		List<Integer> temp = all[now.x][now.y];
		all[now.x][now.y] = new ArrayList<>();

		int nx = now.x + dx[now.dir];
		int ny = now.y + dy[now.dir];

		all[nx][ny].addAll(temp);

		for( int i =0;i < temp.size(); i++ ){
			int idx = temp.get(i);
			list.get(idx).x = nx;
			list.get(idx).y = ny;

		}

		if( all[nx][ny].size() >= 4 ){
			no = true;
		}
	}
	static void red( Horse now ){


		List<Integer> temp = all[now.x][now.y];
		Collections.reverse( temp );

		all[now.x][now.y] = new ArrayList<>();

		int nx = now.x + dx[now.dir];
		int ny = now.y + dy[now.dir];

		all[nx][ny].addAll( temp );

		for( int i =0;i < temp.size(); i++ ){
			int idx = temp.get(i);
			list.get(idx).x = nx;
			list.get(idx).y = ny;
		}

		if( all[nx][ny].size() >= 4 ){
			no = true;
		}
	}
	static class Horse{
		int x,y,dir;
		Horse( int x, int y, int dir ){
			 this.x = x;
			 this.y = y;
			 this.dir = dir;
		}
	}
}
