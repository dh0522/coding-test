package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_15683 {
	static int n,m;
	static int[][] arr;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static List<Point> cctv = new ArrayList<>();
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in ));
		StringTokenizer st= new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];

		for( int i =0 ;i < n; i++ ) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] != 0 && arr[i][j] != 6) {
					cctv.add(new Point (i,j,arr[i][j] ));
				}
			}
		}

		int[][] tmpArr = new int[n][m];
		for( int i =0 ; i < n ;i ++ )
			tmpArr[i] = arr[i].clone();

		dfs( tmpArr , 0 );
		System.out.println(answer);

	}
	private static void dfs( int[][] tmpArr , int idx ){

		if( idx == cctv.size() ){
			count(tmpArr);
			return;
		}

		int[][] tmp = new int[n][m];
		for( int i =0; i< n; i++ )
			tmp[i] = tmpArr[i].clone();

		Point now = cctv.get(idx);

		if( now.cctvNum == 1 ){
			for ( int i =0 ; i <4; i++ ){
				transOne( tmpArr , now.x ,now.y , i );
				dfs( tmpArr, idx+1 );

				for( int k =0; k< n; k++ )
					tmpArr[k] = tmp[k].clone();
			}
		}
		else if( now.cctvNum == 2 ){
			for( int i =0; i < 2 ; i ++ ){
				transTwo(tmpArr,now.x,now.y,i);
				dfs( tmpArr, idx+1 );

				for( int k =0; k < n; k++ )
					tmpArr[k] = tmp[k].clone();
			}
		}else if( now.cctvNum == 3 ){
			for( int i = 0; i< 4; i++ ){
				transThree( tmpArr, now.x , now.y , i);
				dfs( tmpArr , idx +1 );

				for( int k =0; k< n; k++ )
					tmpArr[k] = tmp[k].clone();
			}
		}
		else if( now.cctvNum == 4 ){
			for( int i = 0; i< 4; i++ ){
				transFour( tmpArr, now.x , now.y , i);
				dfs( tmpArr , idx +1 );

				for( int k =0; k< n; k++ )
					tmpArr[k] = tmp[k].clone();
			}
		}
		else{

			transFive( tmpArr, now.x , now.y );
			dfs( tmpArr , idx +1 );
			for( int k =0; k < n; k++ )
				tmpArr[k] = tmp[k].clone();
		}

	}
	private static void transOne( int[][] tmpArr , int x, int y , int num ){

		while( true ){
			x = x + dx[num];
			y = y + dy[num];

			if( x < 0 || y < 0 || x >= n || y >= m )
				break;
			if( tmpArr[x][y] == 6 )
				break;
			tmpArr[x][y] = -1;
		}

	}
	private static void transTwo( int[][] tmpArr , int x, int y , int num ){

		switch (num) {
			case 0:
				for( int i = x+1 ; i < n ; i++ ){
					if( tmpArr[i][y] == 6 )
						break;
					tmpArr[i][y] = -1;
				}
				for( int i = x-1 ; i >= 0; i-- ){
					if( tmpArr[i][y] == 6 )
						break;
					tmpArr[i][y] = -1;
				}
				break;

			case 1:
				for( int i = y-1; i >=0; i-- ){
					if( tmpArr[x][i] == 6 )
						break;
					tmpArr[x][i] = -1;
				}
				for( int i = y+1; i < m; i++ ){
					if( tmpArr[x][i] == 6 )
						break;
					tmpArr[x][i] = -1;
				}
				break;

		}
	}
	private static void transThree( int[][] tmpArr , int x, int y , int num ){

		switch (num) {
			case 0:
				for( int i = x+1 ; i < n ; i++ ){
					if( tmpArr[i][y] == 6 )
						break;
					tmpArr[i][y] = -1;
				}
				for( int i = y+1; i < m; i++ ){
					if( tmpArr[x][i] == 6 )
						break;
					tmpArr[x][i] = -1;
				}
				break;
			case 1:
				for( int i = x+1 ; i < n ; i++ ){
					if( tmpArr[i][y] == 6 )
						break;
					tmpArr[i][y] = -1;
				}
				for( int i = y-1; i >=0; i-- ){
					if( tmpArr[x][i] == 6 )
						break;
					tmpArr[x][i] = -1;
				}
				break;
			case 2:
				for( int i = y-1; i >=0; i-- ){
					if( tmpArr[x][i] == 6 )
						break;
					tmpArr[x][i] = -1;
				}
				for( int i = x-1 ; i >= 0; i-- ){
					if( tmpArr[i][y] == 6 )
						break;
					tmpArr[i][y] = -1;
				}
				break;
			case 3:
				for( int i = x-1 ; i >= 0; i-- ){
					if( tmpArr[i][y] == 6 )
						break;
					tmpArr[i][y] = -1;
				}
				for( int i = y+1; i < m; i++ ){
					if( tmpArr[x][i] == 6 )
						break;
					tmpArr[x][i] = -1;
				}
				break;
		}
	}
	private static void transFour( int[][] tmpArr , int x, int y , int num ){

		switch (num) {
			case 0:
				for( int i = x+1 ; i < n ; i++ ){
					if( tmpArr[i][y] == 6 )
						break;
					tmpArr[i][y] = -1;
				}
				for( int i = y+1; i < m; i++ ){
					if( tmpArr[x][i] == 6 )
						break;
					tmpArr[x][i] = -1;
				}
				for( int i = y-1; i >=0; i-- ){
					if( tmpArr[x][i] == 6 )
						break;
					tmpArr[x][i] = -1;
				}
				break;
			case 1:
				for( int i = x+1 ; i < n ; i++ ){
					if( tmpArr[i][y] == 6 )
						break;
					tmpArr[i][y] = -1;
				}
				for( int i = y-1; i >=0; i-- ){
					if( tmpArr[x][i] == 6 )
						break;
					tmpArr[x][i] = -1;
				}
				for( int i = x-1 ; i >= 0; i-- ){
					if( tmpArr[i][y] == 6 )
						break;
					tmpArr[i][y] = -1;
				}
				break;
			case 2:
				for( int i = y-1; i >=0; i-- ){
					if( tmpArr[x][i] == 6 )
						break;
					tmpArr[x][i] = -1;
				}
				for( int i = x-1 ; i >= 0; i-- ){
					if( tmpArr[i][y] == 6 )
						break;
					tmpArr[i][y] = -1;
				}
				for( int i = y+1; i < m; i++ ){
					if( tmpArr[x][i] == 6 )
						break;
					tmpArr[x][i] = -1;
				}
				break;
			case 3:
				for( int i = x-1 ; i >= 0; i-- ){
					if( tmpArr[i][y] == 6 )
						break;
					tmpArr[i][y] = -1;
				}
				for( int i = y+1; i < m; i++ ){
					if( tmpArr[x][i] == 6 )
						break;
					tmpArr[x][i] = -1;
				}
				for( int i = x+1 ; i < n ; i++ ){
					if( tmpArr[i][y] == 6 )
						break;
					tmpArr[i][y] = -1;
				}
				break;
		}
	}
	private static void transFive( int[][] tmpArr , int x, int y ){
		for( int i = x-1 ; i >= 0; i-- ){
			if( tmpArr[i][y] == 6 )
				break;
			tmpArr[i][y] = -1;
		}
		for( int i = x+1 ; i < n ; i++ ){
			if( tmpArr[i][y] == 6 )
				break;
			tmpArr[i][y] = -1;
		}
		for( int i = y+1; i < m; i++ ){
			if( tmpArr[x][i] == 6 )
				break;
			tmpArr[x][i] = -1;
		}
		for( int i = y-1; i >=0; i-- ){
			if( tmpArr[x][i] == 6 )
				break;
			tmpArr[x][i] = -1;
		}
		return;
	}
	private static void count( int[][] tmpArr ){

		int tmpAnswer = 0;

		for( int i = 0; i < n ; i++ ){
			for( int j =0; j <m ;j++ ){
				if( tmpArr[i][j] == 0 )
					tmpAnswer++;
			}
		}
		answer = Math.min( answer , tmpAnswer );
	}

	static class Point{
		int x,y,cctvNum;
		Point( int x , int y , int cctvNum ){
			this.x = x;
			this.y = y;
			this.cctvNum = cctvNum;
		}
	}
}
