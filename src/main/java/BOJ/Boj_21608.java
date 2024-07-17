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
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		room = new int[n][n];

		HashMap<Integer , List<Integer> > hm = new HashMap<>();


		StringTokenizer st;

		for( int i =0 ; i < n*n ; i++ ) {

			st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken());

			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < 4; j++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			hm.put( now , list );
			search(now, list);

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

	static class Point{
		int x,y,adjNum,zeroNum;
		public Point( int x, int y , int adjNum ,int zeroNum ){
			this.x = x;
			this.y = y;
			this.adjNum = adjNum;
			this.zeroNum = zeroNum;
		}
	}

	static private void search( int now,  List<Integer> list ){
		List<Point> adjList = new ArrayList<>();

		for( int i= 0 ;i < n ; i++ ){
			for( int j = 0 ; j< n ;j ++ ){

				if( room[i][j] != 0 )
					continue;

				int adjNum = 0;
				int zeroNum = 0;

				for( int d =0 ; d < 4; d++ ){

					int nx = i + dx[d];
					int ny = j + dy[d];

					if( nx < 0 || ny <0 || nx >= n || ny >= n )
						continue;

					if( list.contains( room[nx][ny] ) ){
						adjNum++;
					}
					if( room[nx][ny] == 0 )
						zeroNum++;
				}

				if( adjList.size() == 0 ){
					adjList.add(new Point(i,j,adjNum, zeroNum ));
				}else if( adjList.get(0).adjNum < adjNum ){
					adjList.clear();
					adjList.add( new Point(i,j,adjNum , zeroNum ) );
				}else if( adjList.get(0).adjNum == adjNum ){
					adjList.add(new Point(i,j,adjNum, zeroNum ));
				}

			}
		}

		// 1을 만족하는 칸이 하나
		if( adjList.size() == 1 ){
			Point point = adjList.get(0);
			room[point.x][point.y] = now;
			return;
		}

		// zeroNum 판단
		List<Point> tmpList = new ArrayList<>();
		int max = 0;
		for( int i =0 ;i < adjList.size(); i++ ){
			Point point = adjList.get(i);
			if( max < point.zeroNum ){
				tmpList.clear();
				tmpList.add(point);
				max = point.zeroNum;
			}else if( max == point.zeroNum ){
				tmpList.add(point);
			}
		}



		if( tmpList.size() == 1 ){
			Point point = tmpList.get(0);
			room[point.x][point.y] = now;
			return;
		}

		Collections.sort(tmpList, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				if (p1.x != p2.x) {
					return p1.x - p2.x; // x 값이 작은 순으로 정렬
				} else {
					return p1.y - p2.y; // x 값이 같으면 y 값이 작은 순으로 정렬
				}
			}
		});
		Point point = tmpList.get(0);
		room[point.x][point.y] = now;
		return;
	}
}
