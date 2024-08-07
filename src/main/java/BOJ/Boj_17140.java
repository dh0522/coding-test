package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_17140 {
	static int[][] arr = new int[101][101] ;
	static int row = 3, column = 3;
	static HashMap<Integer,Integer> hm;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken())-1;
		int c = Integer.parseInt(st.nextToken())-1;
		int k = Integer.parseInt(st.nextToken());

		for( int i=0; i < 3; i++ ){
			st = new StringTokenizer(br.readLine());
			for( int j=0; j< 3; j++ )
				arr[i][j] = Integer.parseInt(st.nextToken());

		}

		int answer = 0;

		while( arr[r][c] != k ){

			if( answer == 101 ) {
				answer = -1;
				break;
			}

			if( row >= column ){
				calcR();
			}else{
				calcC();
			}

			answer++;
		}


		System.out.println( answer );
	}
	private static void calcC(){

		int[][] temp = new int[101][101];


		for( int j =0; j < column; j++ ){
			hm = new HashMap<>();
			for(int i =0; i < row; i ++ ){
				int now = arr[i][j];
				if( now == 0 )
					continue;
				hm.put( now , hm.getOrDefault( now , 0 )+ 1);
			}

			List<Integer> keySet = new ArrayList<>(hm.keySet());
			keySet.sort(new Comparator<Integer>(){
				@Override
				public int compare(Integer o1 , Integer o2 ){
					if( hm.get(o1) == hm.get(o2) )
						return o1 - o2;
					return hm.get(o1) - hm.get(o2);
				}
			});
			int newRow = 0;
			for( Integer key : keySet ){
				temp[newRow++][j] = key;
				temp[newRow++][j] = hm.get(key);
			}

			row = Math.max( row , newRow );
		}

		arr = temp;
	}
	private static void calcR(){

		int[][] temp = new int[101][101];

		for( int i =0; i < row; i++ ){
			hm = new HashMap<>();
			int newColumn = 0;
			for( int j=0; j< column; j++ ){
				int now = arr[i][j];
				if( now == 0 )
					continue;
				hm.put( now , hm.getOrDefault(now,0) + 1 );
			}

			List<Integer> keySet = new ArrayList<>(hm.keySet());
			keySet.sort(new Comparator<Integer>(){
				@Override
				public int compare(Integer o1 , Integer o2 ){
					if( hm.get(o1) == hm.get(o2) )
						return o1 - o2;
					return hm.get(o1) - hm.get(o2);
				}
			});

			for( Integer key : keySet ){
				temp[i][newColumn++] = key;
				temp[i][newColumn++] = hm.get(key);
			}
			column = Math.max( column , newColumn );
		}
		arr = temp;

	}
}
