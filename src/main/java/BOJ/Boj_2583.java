package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2583 {
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] map = new int[m][n];
		visited = new boolean[m][n];
		List<Integer> list = new ArrayList<>();

		for( int i= 0; i< k ; i++ ){
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());

			for( int x = x1; x <x2; x++ ){
				for( int y = y1 ; y< y2 ; y ++ ){
					map[x][y] = 1;

				}
			}
		}

		int answer = 0;

		for( int j = 0 ; j< n ; j++ ) {
			for( int i = 0; i < m;  i++ ){
				if( map[i][j] == 0 && ! visited[i][j]  ){
					answer++;
					list.add( bfs(i,j,map) );
				}
			}
		}

		Collections.sort(list);
		for( int i : list )
			sb.append(i+" ");

		System.out.println(answer);
		System.out.println(sb);
	}
	private static int bfs(int x, int y , int[][] map ){

		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{x,y});
		visited[x][y] = true;
		int num = 1;

		while (!q.isEmpty() ){
			int[] now = q.poll();
			x = now[0];
			y = now[1];

			for( int i = 0 ; i < 4; i++ ){
				int nx = x +dx[i];
				int ny = y + dy[i];

				if( nx < 0 || ny < 0 || nx >= map.length  || ny >= map[0].length )
					continue;

				if( map[nx][ny] == 1 || visited[nx][ny] )
					continue;

				q.add(new int[]{nx,ny});
				visited[nx][ny] = true;
				num++;
			}
		}

		return num;
	}
}
























