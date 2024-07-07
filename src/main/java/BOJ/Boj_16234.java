package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16234 {
	static int[][] country;
	static int n, l, r;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][] possible;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		country = new int[n][n];

		for( int i =0 ; i < n ; i++ ){
			st = new StringTokenizer(br.readLine());
			for( int j =0 ;j < n; j++ ){
				country[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		while( true ){
			int num = 0;
			possible = new boolean[n][n];

			for( int i = 0 ; i < n; i++ ){
				for( int j = 0 ;j < n ; j++ ){
					if( !possible[i][j] ) {
						num += isOpen(i, j);
					}
				}
			}

			if( num == 0 )
				break;
			answer++;

		}
		System.out.println(answer);
	}
	public static int isOpen(int x , int y){

		Queue<int[]> q = new LinkedList<>();
		List<int[]> list = new ArrayList<>();

		q.add(new int[]{x,y});
		while(!q.isEmpty()){
			int[] now = q.poll();
			x = now[0];
			y = now[1];

			for( int i = 0; i < 4; i++ ){
				int nx = x + dx[i];
				int ny = y + dy[i];

				if( nx < 0 || ny < 0 || nx >=n || ny >= n )
					continue;

				if( possible[nx][ny] )
					continue;

				int diff = Math.abs( country[x][y] - country[nx][ny] );
				if( l <= diff && diff <= r ){
					possible[nx][ny] = true;
					q.add(new int[]{nx,ny});
					list.add(new int[]{nx,ny});
				}
			}
		}
		int allPeople = 0;

		// 국경선 열고 인구 나누기
		for( int i =0 ; i <list.size(); i++ ){
			int[] nara = list.get(i);
			allPeople += country[nara[0]][nara[1]];
		}

		for (int i = 0 ; i < list.size(); i++ ){
			int[] nara= list.get(i);
			country[nara[0]][nara[1]] = allPeople/list.size();
		}

		return list.size();
	}
}
