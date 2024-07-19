package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_17140 {
	static int row = 3, column = 3;
	static int[][] arr = new int[101][101];
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// arr[r][c] = k 가 되기 위한 최소 시간을 구해보자.
		int r = Integer.parseInt(st.nextToken()) - 1;
		int c = Integer.parseInt(st.nextToken()) - 1;
		int k = Integer.parseInt(st.nextToken());

		/**
		 *		첫번짼는 반드시 R연산을 수행하게 되어 있음
		 */

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		while( arr[r][c] != k ){

			if( answer == 101 )
				break;

			if( row >= column ){
				calcR();
			}else{
				calcC();
			}
			answer++;


		}

		if (answer == 101 )
			System.out.println(-1);
		else
			System.out.println(answer);

	}
	private static void calcR(){

		 int[][] tmpArr = new int[101][101];

		 for( int i =0 ; i< row; i++ ){
			 HashMap<Integer,Integer> hm = new HashMap<>();
			 for( int j =0; j< column; j++ ){

				 int now = arr[i][j];
				 if( now == 0 )
					 continue;
				 hm.put( now , hm.getOrDefault(now , 0) +1 );

			 }

			 List<Pair> list = new ArrayList<>();
			 for( Map.Entry<Integer,Integer> entry : hm.entrySet() ){
				 list.add(new Pair(entry.getKey(), entry.getValue()));
			 }

			 Collections.sort(list);

			 int idx = 0;
			 for( int k = 0; k< list.size(); k++  ){
				 Pair now = list.get(k);
				 tmpArr[i][idx++] = now.num;
				 tmpArr[i][idx++] = now.cnt;
			 }

			 column = Math.max( column , idx );
		 }
		 arr = tmpArr;

	}
	private static void calcC(){

		int[][] tmpArr = new int[101][101];

		for( int i =0 ; i< column; i++ ){
			HashMap<Integer,Integer> hm = new HashMap<>();
			for( int j =0; j< row; j++ ){

				int now = arr[j][i];
				if( now == 0 )
					continue;
				hm.put( now , hm.getOrDefault(now , 0) +1 );
			}

			List<Pair> list = new ArrayList<>();
			for( Map.Entry<Integer,Integer> entry : hm.entrySet() ){
				list.add(new Pair(entry.getKey(), entry.getValue()));
			}

			Collections.sort(list);

			int idx = 0;
			for( int k = 0; k< list.size(); k++  ){
				Pair now = list.get(k);
				tmpArr[idx++][i] = now.num;
				tmpArr[idx++][i] = now.cnt;
			}


			row = Math.max( idx , row );
		}
		arr = tmpArr;

	}
	static class Pair implements Comparable<Pair>{
		 int num;
		 int cnt;

		 public Pair(int num,int cnt){
			 this.num = num;
			 this.cnt = cnt;
		 }

		 @Override
		public int compareTo(Pair o){
			 if(this.cnt==o.cnt)
				 return this.num-o.num;
			 return this.cnt-o.cnt;
		 }
	}
}
