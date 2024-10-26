package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_18513 {
	static int n,k;
	static long answer = 0;
	static List<Integer> lake = new ArrayList<>();
	// 13초에 틀림
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for ( int i=0; i< n; i++ ) {
			lake.add( Integer.parseInt(st.nextToken()) );
		}


		bfs();

		System.out.println(answer);

	}
	private static void bfs( ){

		// q = 집의 위치임.
		Queue<Integer> q = new LinkedList<>();





		List<Integer> home = new ArrayList<>();
		int idx = 1;

		while( k > 0 ){

			for ( int i=0; i < lake.size(); i++ ){

				int nowLake = lake.get(i);
				System.out.println(nowLake);
				System.out.println(nowLake-idx);
				if ( nowLake-idx >= 0 && !check[nowLake-idx] ){
					check[nowLake-idx] = true;
					//home.add( nowLake - idx );
					answer += Math.abs( idx );
					k-- ;
					if ( k == 0 )
						return;
				}

				if ( nowLake+idx < check.length && !check[nowLake+idx] ){
					check[nowLake+idx] = true;
					//home.add( nowLake - idx );
					answer += Math.abs( idx );
					k--;
					if ( k== 0 )
						return;
				}

			}

			idx++;
		}
	}
}





















