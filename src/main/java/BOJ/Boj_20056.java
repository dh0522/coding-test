package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_20056 {
	static int n,m;
	static int[][] arr;
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	static List<Ball> balls = new ArrayList<>();
	static Queue<Ball>[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		map = new Queue[n][n];
		for( int i =0; i < n; i++ ){
			for( int j=0; j <n ; j++)
				map[i][j] = new LinkedList<>();
		}


		arr = new int[n][n];

		for( int i = 0; i < m ; i++ ){
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			balls.add( new Ball(r,c,m,s,d) );
		}

		for( int i =0; i < k ; i++ ){
			move();
		}

		int answer = 0;
		for( Ball ball : balls ) {
			answer += ball.m;
		}
		System.out.println(answer);

	}
	private static void second(int x, int y ) {

		int count = map[x][y].size();
		int dirCount = 0;

		int newM = 0;
		int newS = 0;

		while( !map[x][y].isEmpty() ){
			Ball ball = map[x][y].poll();
			newM += ball.m;
			newS += ball.s;

			if( ball.d% 2 == 0 )
				dirCount++;

			balls.remove( ball );
		}

		if( dirCount == count || dirCount == 0 ){
			dirCount = 0;
		}else dirCount = 1;

		newM /= 5;
		newS /= count;

		if( newM == 0 ){
			return;
		}
		arr[x][y] = 4;
		for( int j = 0; j < 4; j++ ){
			balls.add( new Ball( x,y ,newM,newS,dirCount ) );
			dirCount += 2;
		}
	}
	private static void move(){

		for( int i =0; i < balls.size(); i++ ){
			Ball ball = balls.get(i);

			int r = ball.r;
			int c = ball.c;
			int d = ball.d;
			int s = ball.s%n;
			arr[r][c]--;

			ball.r = ( r + dx[d]*s + n )%n;
			ball.c = ( c + dy[d]*s + n )%n;

			map[ball.r][ball.c].add( ball );
		}

		for( int i =0; i < n; i++ ){
			for( int j=0; j < n; j++ ){
				if( map[i][j].size()  >= 2 ) {
					second(i,j);
				}
				else map[i][j].clear();
			}
		}

	}
	static class Ball{
		int r,c,m,s,d;
		Ball( int r , int c ,int m, int s, int d ){
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
}
