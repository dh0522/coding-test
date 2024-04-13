package SamsungSWTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_21608 {
	static private int n;
	static private int[][] classroom;
	static private int[] dx = {1,-1,0,0};
	static private int[] dy = {0,0,-1,1};
	static private int answer =0;
	static private Map<Integer , List<Integer> > map = new HashMap<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt( br.readLine() );
		Queue<Integer> q = new LinkedList<>();

		classroom = new int[n][n];

		StringTokenizer st ;
		for( int i =0; i< n*n ; i++ ){
			st = new StringTokenizer(br.readLine());

			List<Integer> like = new LinkedList<>();
			int member = 0;
			for( int j=0; j < 5; j++ ){
				if( j == 0 ){
					member = Integer.parseInt(st.nextToken());
					q.add( member );
				}
				else
					like.add( Integer.parseInt( st.nextToken() ) );
			}
			map.put( member , like );

		}

		for( int i = 0 ; i < n*n ; i++ ){
			int now = q.poll();
			List<Integer> list = map.get(now);
			int[] loc = findSeat( list );
			classroom[loc[0]][loc[1]] = now;
		}

		for( int i = 0 ; i < n;  i++ ){

			for( int j = 0 ; j < n ; j++ ){
				int num = 0;
				List<Integer> list = map.get(classroom[i][j]);
				for( int d = 0;d<4; d++ ){

					int nx = i + dx[d];
					int ny = j + dy[d];
					if (nx < 0 || ny < 0 || nx >= n|| ny >=n)
						continue;

					if( list.contains( classroom[nx][ny]) ){
						num++;
					}

				}
				answer += Math.pow( 10 ,num -1);
			}


		}

		System.out.println(answer);


	}

	private static int[] findSeat( List<Integer> list ) {

		List<Seat> lst = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				// 이미 칸에 누가 들어갔으면.
				if (classroom[i][j] != 0)
					continue;

				int likeNum = 0;
				int zeroNum = 0;
				// now == 0,, 0
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];

					if (nx < 0 || ny < 0 || nx >= classroom.length || ny >= classroom.length)
						continue;

					if ( list.contains( classroom[nx][ny] ) )
						likeNum++;

					if (classroom[nx][ny] == 0)
						zeroNum++;

				}
				lst.add( new Seat(i , j ,likeNum , zeroNum));

			}
		}

		Seat now = lst.get(0);
		for( int i = 1 ; i < lst.size() ; i ++){
			if (now.compareTo(lst.get(i)) > 0 )
				now = lst.get(i);
		}

		return new int[]{now.x, now.y};

	}
}
class Seat implements Comparable<Seat>{

	int x, y , likeSum, emptySum;

	public Seat(int x , int y , int likeSum, int emptySum){
		this.x = x;
		this.y = y;
		this.likeSum = likeSum;
		this.emptySum = emptySum;
	}

	@Override
	public int compareTo( Seat now ) {

		if( likeSum != now.likeSum ){
			return -( likeSum- now.likeSum);
		}
		if( emptySum != now.emptySum)
			return -(emptySum - now.emptySum);

		if( x!= now.x )
			return x - now.x;

		return y - now.y;
	}
}

















