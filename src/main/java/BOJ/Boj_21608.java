package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_21608 {
	static int[][] room;
	static int n;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static HashMap<Integer ,List<Integer> > hm = new HashMap<>();
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		room = new int[n][n];

		StringTokenizer st;
		for( int i =0 ; i < n*n ; i++ ) {

			st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken());
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < 4; j++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			hm.put( now , list );
			bestSearch(now,list);
		}

		int answer = 0;
		for( int i = 0 ; i < n ; i++ ){
			for( int j = 0; j <n ;j++ ){
				int now = room[i][j];
				int good = 0;
				List<Integer> list = new ArrayList<>(hm.get(now));
				for( int d =0 ; d < 4; d++ ) {

					int nx = i + dx[d];
					int ny = j + dy[d];

					if (nx < 0 || ny < 0 || nx >= n || ny >= n)
						continue;

					if( list.contains( room[nx][ny] ))
						good++;
				}
				if( good == 0 )
					continue;
				answer += Math.pow(10, good-1);
			}
		}
		System.out.println(answer);

	}
	static private void bestSearch( int now , List<Integer> list ){

		int maxFriends = 0;
		int maxZero = 0;
		int locX = Integer.MAX_VALUE ;
		int locY = Integer.MAX_VALUE;

		for( int i = 0 ; i < n ;i++ ){
			for(int j =0 ;j <n ;j ++ ){
				if( room[i][j] != 0 )
					continue;

				int friend = 0;
				int zero = 0;

				for( int d=0; d <4; d++ ){
					int nx = i + dx[d];
					int ny = j + dy[d];

					if( nx < 0 || ny <0 || nx >= n || ny >= n )
						continue;

					if( list.contains( room[nx][ny] ) ){
						friend++;
					}
					if( room[nx][ny] == 0 )
						zero++;
				}

				if( friend > maxFriends || (friend == maxFriends && zero > maxZero) ||
					(friend == maxFriends && zero == maxZero && i < locX) || (friend == maxFriends && zero == maxZero && i == locX && j < locY ) ){
					maxFriends = friend;
					maxZero = zero;
					locX = i;
					locY = j;
				}

			}
		}

		room[locX][locY] = now;
		return;

	}
}
