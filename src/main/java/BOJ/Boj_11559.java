package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

public class Boj_11559 {
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static char[][] arr;
	static boolean[][] check;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new char[12][6];
		for (int i=0; i< 12; i++ ){
			arr[i] = br.readLine().toCharArray();
		}

		int answer = 0;
		while( true ){

			check = new boolean[12][6];
			int count = 0;
			for (int i=0; i < 12; i++ ){
				for ( int j=0; j < 6; j++ ){
					if ( arr[i][j] != '.' && !check[i][j] ){
						if ( dfs( i, j ) )
							count++;
					}
				}
			}
			if (count == 0 )
				break;
			answer++;

			for( int j = 0; j < 6; j++ ){
				String temp = "";

				for (int i = 11; i >= 0 ; i-- ){
					if ( arr[i][j] != '.')
						temp += arr[i][j];
				}

				while( temp.length() != 12 ){
					temp += ".";
				}

				for (int i =0 ; i < 12 ; i ++ ){
					arr[11-i][j] = temp.charAt(i);
				}
			}

		}


		System.out.println(answer);

	}
	static private boolean dfs( int x , int y ){

		Queue<int[]> q = new LinkedList<>();
		List<int[]> list = new ArrayList<>();

		q.add(new int[]{x,y});
		list.add(new int[]{x,y});

 		int count = 0;

		while( !q.isEmpty() ){
			int[] now = q.poll();

			for (int i =0; i < 4; i++ ){
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];

				if( nx < 0 || ny < 0 || nx >= 12 || ny >= 6 )
					continue;
				if ( check[nx][ny]  )
					continue;
				if ( arr[nx][ny] != arr[x][y] )
					continue;

				check[nx][ny] = true;
				count++;
				q.add(new int[]{nx,ny} );
				list.add(new int[]{nx,ny} );

			}

		}

		if ( count  < 4 )
			return false;

		for (int[] i : list ){
			arr[i[0]][i[1]] = '.';
		}

		return true;
	}
}
