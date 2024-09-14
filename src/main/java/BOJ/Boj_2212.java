package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_2212 {
	static int n,k;
	static List<Integer> sensor = new ArrayList<>();
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt( br.readLine());
		k = Integer.parseInt(br.readLine());

		List<Integer> building = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for( int i=0; i < n; i++ ){
			int now = Integer.parseInt(st.nextToken());
			sensor.add ( now ) ;
		}

		Collections.sort( sensor );

		permutation( 0 , 0  , building );
		System.out.println( answer );
	}
	private static void permutation( int depth , int count  , List<Integer> building ){
		if( depth == n ){
			calc( building );
			return;
		}

		for( int i = count; i < k; i++ ){
			if( 0 < depth ){
				int ex = building.get(depth-1);
				if( ex > i )
					continue;
			}

			building.add( i );
			permutation( depth+1 , count , building );
			building.remove( depth );
		}

	}
	private static void calc( List<Integer> building ){

		List<List<Integer>> list = new ArrayList<>();

		for( int i=0; i < k; i ++ )
			list.add( new ArrayList<>() );


		for( int i=0 ; i< n ; i++ ){
			int nowBuilding = building.get(i);
			list.get(nowBuilding).add( sensor.get(i) );
		}

		int sum = 0;
		for( int i =0; i < k; i++ ){
			List<Integer> tmp = list.get(i);
			if( tmp.size() == 0 || tmp.size() == 1 )
				continue;

			int min = tmp.get(0);
			int max = tmp.get(tmp.size()-1);

			sum += max - min;
		}

		answer = Math.min( sum, answer );
		return ;

	}

}
