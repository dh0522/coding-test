package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj_15787 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean[][] train = new boolean[n][20];

		/**
		 * 	1 i x
		 * 	i번째 기차 -> x번째 좌석에 사람을 태워라. 이미 있다면 넘어가
		 *
		 * 	2 i x
		 * 	i번째 기차 -> x번째 좌석에 앉은 사람 하차해라. 이미 없다면 넘어가
		 *
		 *  3 i x
		 *  i번째 기차에 앉은 사람들이 한칸씩 뒤로간다.
		 *  if 20번째 자리에 사람이 있엇다면 하차한다.
		 *
		 *  4 i x
		 *  i번째 기차에 앉은 사람들 모두 한칸씩 앞으로 간다.
		 *  1번째 라면, 하차한다.
		 */

		int x = 0;
		for( int k =0; k < m ; k++ ){
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			int i = Integer.parseInt(st.nextToken())-1;

			switch( order ){
				case 1:
					x = Integer.parseInt(st.nextToken())-1;
					if( !train[i][x] )
						train[i][x] = true;
					break;

				case 2:
					x = Integer.parseInt(st.nextToken())-1;
					if( train[i][x] )
						train[i][x] = false;
					break;

				case 3:
					for( int j = 19; j > 0 ;j-- ){
						train[i][j] = train[i][j-1];
					}
					train[i][0] = false;
					break;

				case 4:
					for( int j = 0; j < 19; j++ ){
						train[i][j] = train[i][j+1];
					}
					train[i][19] = false;
					break;
			}
		}

		Set<String> list = new HashSet<>();
		for( int i = 0; i < n; i++ ){

			String tmp = "";
			for( int j=0; j < 20 ;j ++ ){
				if( train[i][j] )
					tmp+=1;
				else tmp+=0;
			}


			list.add( tmp );
		}

		System.out.println(list.size());

	}
}
