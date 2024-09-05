package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_17837 {
	static int n,k;
	static int[][] arr;
	static List<Integer>[][] list;
	static HashMap< Integer, Horse > hm = new HashMap<>();
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static boolean notOk = false;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[n][n];
		list = new ArrayList[n][n];

		for( int i=0; i < n; i++ ){
			st = new StringTokenizer(br.readLine());
			for( int j=0; j<n; j++ ){
				arr[i][j] = Integer.parseInt(st.nextToken());
				list[i][j] = new ArrayList<>();
			}
		}

		for( int i=0; i < k ; i++ ){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken())-1;

			hm.put( i , new Horse(x,y,dir,i) );
			list[x][y].add( i );
		}

		int turn = 0;

		while( !notOk  && turn < 1001 ){

			for( int i=0; i < k; i++ ){

				Horse horse = hm.get(i);

				int nx = horse.x + dx[horse.dir];
				int ny = horse.y + dy[horse.dir];

				if( nx < 0 || ny < 0 || nx >= n | ny >= n || arr[nx][ny] == 2 ){

					int newDir = -1;

					if( horse.dir == 0 )	newDir=1;
					else if( horse.dir == 1 )	newDir=0;
					else if( horse.dir == 2 )	newDir=3;
					else if( horse.dir == 3 )	newDir=2;

					hm.get(i).dir = newDir;
					horse.dir = newDir;

					nx = horse.x + dx[newDir];
					ny = horse.y + dy[newDir];

					if( nx < 0 || ny <0 || nx >=n || ny >= n || arr[nx][ny] == 2 )
						continue;

				}

				if ( arr[nx][ny] == 0 ) {
					white(horse);
				}else if( arr[nx][ny] == 1 ){
				 	red(horse);
				}

				if (notOk)
					break;

			}

			turn++;
		}

		System.out.println( turn == 1001 ? -1 : turn );
	}
	static void white(Horse now){

		int x = now.x;
		int y = now.y;

		int nx =x + dx[now.dir];
		int ny = y + dy[now.dir];

		// index = now horse가 (x,y)에서 몇번째인지

		int start = list[x][y].indexOf( now.order );
		int size = list[x][y].size();


		for( int i = 0 ; i < size-start ; i++ ){


			// idx = all horse 중에 몇번째인지.
			int idx = list[x][y].get(start);
			list[x][y].remove( start );

			hm.get(idx).x = nx;
			hm.get(idx).y = ny;

			list[nx][ny].add( idx );
		}

		if( list[nx][ny].size() >= 4 )
			notOk = true;

	}
	static void red(Horse now){

		int x = now.x;
		int y = now.y;

		int nx = x + dx[now.dir];
		int ny = y + dy[now.dir];

		// index = now horse가 (x,y)에서 몇번째인지

		int start = list[x][y].indexOf( now.order );
		int size = list[x][y].size();

		List<Integer> temp = new ArrayList<>();
		for(int i = 0 ; i < size-start ; i++ ){

			int idx = list[x][y].get(start);
			list[x][y].remove( start );

			hm.get(idx).x = nx;
			hm.get(idx).y = ny;

			temp.add( idx );
		}

		Collections.reverse( temp );
		list[nx][ny].addAll(temp);

		if( list[nx][ny].size() >= 4 )
			notOk = true;

	}

	static class Horse{
		int x,y,dir,order;
		Horse ( int x, int y, int dir, int order ){
			this.x = x;
			this.y= y;
			this.dir = dir;
			this.order = order;
		}
	}
}
