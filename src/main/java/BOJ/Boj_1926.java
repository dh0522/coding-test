package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1926 {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] visited;
	static int[][] paper;
	static int answer = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		visited = new boolean[n][m];
		paper = new int[n][m];

		for( int i = 0; i< n; i++ ){
			st = new StringTokenizer(br.readLine());
			for( int j =0 ;j < m; j++ ){
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int kind = 0;

		for( int i = 0 ;i < n; i++ ){
			for( int j =0 ;j < m ;j ++ ){
				if( paper[i][j] == 1 && !visited[i][j] ){
					bfs(i,j);
					kind++;
				}
			}
		}

		System.out.println(kind);
		if( answer < 0 )
			System.out.println(0);
		else System.out.println(answer);

	}

	public static void bfs( int x ,int y ){

		Queue<int[]> q = new LinkedList<>();
		q.add( new int[]{x,y} );
		int area = 1;

		while( !q.isEmpty() ){

			int[] now = q.poll();
			x = now[0];
			y = now[1];
			visited[x][y] = true;

			for( int d = 0; d<4; d ++ ){
				int nx = x + dx[d];
				int ny = y + dy[d];

				if( nx < 0 || ny < 0 || nx >= paper.length || ny >= paper[0].length )
					continue;

				if( paper[nx][ny] == 1 && !visited[nx][ny]){
					area++;
					visited[nx][ny] = true;
					q.add(new int[]{nx,ny});
				}



			}
		}

		answer = Math.max( answer , area );

	}
}
