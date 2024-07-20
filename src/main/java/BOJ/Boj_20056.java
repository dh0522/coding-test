package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_20056 {
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	static int n,m;
	static List<Ball> list = new ArrayList<>(); // fireBall list
	static Queue<Ball>[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int k = Integer.parseInt(st.nextToken());

		map = new Queue[n][n];
		for( int i= 0; i< n; i++ ){
			for( int j=0; j< n; j ++ ){
				map[i][j] = new LinkedList<>();
			}
		}


		for( int i=0 ; i <m ;i++ ){
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			list.add(new Ball( x,y,m,s,d ));
		}

		while( k-- > 0 ){
			move();
			for(int i=0; i< n ;i++ ){
				for( int j =0; j< n ;j++ ){
					if( map[i][j].size() >= 2 )
						divide(i,j);
					else
						map[i][j].clear();
				}
			}
		}

		int answer =0;

		for( int i=0; i< list.size(); i++ ){
			answer += list.get(i).w;
		}
		System.out.println(answer);

	}
	private static void divide( int x , int y ) {

		int weight = 0;
		int speed = 0;

		boolean direction = true;

		int d = map[x][y].peek().d % 2;
		int count = map[x][y].size();

		while( !map[x][y].isEmpty() ){

			Ball ball = map[x][y].poll();
			weight += ball.w;
			speed += ball.s;

			if( (ball.d)%2 != d ){
				direction = false;
			}
			list.remove(ball);
		}

		if( direction )
			d = 0;
		else d = 1;

		weight /= 5 ;
		speed /= count ;

		if( weight == 0 )
			return;


		for( int i = 0; i < 4; i++ ){
			list.add( new Ball( x,y, weight,speed, d ) );
			d+=2;
		}


	}
	private static void move( ){

		for( int i = 0; i < list.size(); i++ ){

			Ball ball = list.get(i);

			int x = ball.x;
			int y = ball.y;
			int d = ball.d;
			int num = ball.s%n;

			ball.x = ( x + dx[d]* num + n ) % n;
			ball.y = ( y + dy[d]* num + n ) % n;

			map[ball.x][ball.y].add(ball);

		}


	}

	public static class Ball{
		int x,y,w,s,d;
		public Ball( int x, int y ,int w , int s , int d ){
			this.x = x;
			this.y = y;
			this.w = w;
			this.s = s;
			this.d = d;
		}
	}
}
