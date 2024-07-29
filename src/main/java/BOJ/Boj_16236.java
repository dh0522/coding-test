package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16236 {
	static int[][] arr;
	static int sharkSize = 2;
	static int n;
	static int nowX ,nowY ;
	static Fish fish;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;

		arr = new int[n][n];
		for( int i =0; i< n; i++ ){
			st = new StringTokenizer(br.readLine());
			for( int j =0; j< n ;j++ ) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if( arr[i][j] == 9 ){
					nowX = i;
					nowY = j;
					arr[i][j] = 0;
				}
			}
		}

		int eatFish = 0;
		int answer = 0;

		while( true ){
			boolean now = searchDis(nowX, nowY);
			if( !now )
				break;

			answer += fish.d;
			arr[fish.x][fish.y] = 0;
			nowX = fish.x;
			nowY = fish.y;
			eatFish++;


			if( eatFish == sharkSize ) {
				sharkSize++;
				eatFish = 0;
			}
		}

		System.out.println(answer);

	}
	static private boolean searchDis( int x , int y ){
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};

		List<Fish> list = new ArrayList<>();

		int[][] visited = new int[n][n];
		visited[x][y] = 1;

		Queue<int[]> q = new LinkedList<>();
		q.add( new int[]{x,y} );

		while( !q.isEmpty() ){

			int[] tmp = q.poll();
			x = tmp[0];
			y = tmp[1];

			for( int i =0; i < 4; i++ ){
				int nx = x + dx[i];
				int ny = y + dy[i];

				if( nx < 0 || ny < 0 || nx >= n || ny >= n )
					continue;

				if( arr[nx][ny] > sharkSize )
					continue;

				if( visited[nx][ny] != 0 )
					continue;

				visited[nx][ny] = visited[x][y] + 1;
				q.add(new int[]{nx,ny});
				if( arr[nx][ny] != 0 && sharkSize > arr[nx][ny] ){
					list.add( new Fish(nx,ny,visited[nx][ny]-1) );
				}
			}

		}
		if(list.size() == 0)
			return false;

		Collections.sort( list );
		fish = list.get(0);


		return true;
	}

	static class Fish implements Comparable<Fish> {
		int x,y,d;

		Fish( int x, int y,  int d ){
			this.x = x;
			this.y = y;
			this.d = d;
		}
		@Override
		public int compareTo( Fish fish ){
			if( this.d != fish.d )
				return this.d - fish.d;
			if( this.x != fish.x )
				return this.x -fish.x;
			return this.y - fish.y;

		}
	}
}












