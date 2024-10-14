package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_11967 {
	static int n;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static List<Room> first = new ArrayList<>();
	static List<Room> second = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for (int i=0; i <m ; i++ ){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;

			first.add( new Room (x,y) );
			second.add( new Room (a,b) );
		}

		dfs( 0, 0 );

	}
	private static void dfs( int x , int y  ) {

		Queue<Room> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];

		q.add( new Room(x,y) );
		visited[x][y] = true;

		int answer = 1;

		while( !q.isEmpty() ){

			Room now = q.poll();

			x = now.x;
			y = now.y;

			while ( first.contains(now) ){

				int idx = first.indexOf( now );
				Room next = second.get( idx );

				first.remove( idx );
				second.remove( idx );

				int nx = next.x;
				int ny = next.y;

				if ( visited[nx][ny] )
					continue;

				visited[nx][ny] = true;
				answer++;
				q.add( next );

			}

		}

		System.out.println( answer );
	}
	static class Room{
		int x,y;
		public Room( int x , int y  ){
			this.x = x;
			this.y = y;

		}

		@Override
		public boolean equals( Object o ){
			if(this==o)
				return true;
			if ( o== null || getClass() != o.getClass() )
				return false;
			Room room = (Room) o;

			return x == room.x && y == room.y;
		}


		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}
}
