package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_2891 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int answer = n;

		List<Integer> broken = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i =0; i < s ; i++ ){
			broken.add(Integer.parseInt(st.nextToken()));
			answer--;
		}

		List<Integer> add = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for( int i =0; i< r; i++ ){
			int now = Integer.parseInt(st.nextToken());
			if( broken.contains( now ) ){
				broken.remove( broken.indexOf( now ) );
				answer++;
			}else
				add.add(now);
		}

		Collections.sort( broken );
		Collections.sort( add );

		int len = add.size();
		for ( int i=0; i < len ; i++ ){
			int remainHave = add.get(i);
			if( broken.isEmpty() )
				break;

			if( broken.contains( remainHave ) ){
				broken.remove( broken.indexOf(remainHave) );
				answer++;

			}
			else if( remainHave-1 >= 0 && broken.contains(remainHave-1) ){
				broken.remove(broken.indexOf( remainHave-1 ));
				answer++;

			}else if( remainHave +1 < n+1 && broken.contains( remainHave +1 ) ){
				broken.remove( broken.indexOf( remainHave+1 ) );
				answer++;
			}
		}

		System.out.println( n - answer );
	}
}
