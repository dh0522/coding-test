package coding_study.setmap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_10815 {
	public static void main(String[] args) throws Exception {

		int n = 0;
		int m = 0;
		int num = 0;
		StringTokenizer st;
		// 어떤 자료구조 ?? list 안돼 arr 안돼
		/**
		 *  list.contains X
		 *  arr for문 X
		 *  => set -> hash값이니까 탐색 O(1)
		 */
		Set<Integer> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

		n = Integer.parseInt( br.readLine() );
		st = new StringTokenizer(br.readLine());

		while(n-- > 0){
			set.add( Integer.parseInt(st.nextToken()) );
		}

		m = Integer.parseInt( br.readLine() );
		st = new StringTokenizer(br.readLine());

		while( m-- > 0 ){

			num = Integer.parseInt(st.nextToken());
			if( set.contains(num) )
				sb.append(1);
			else
				sb.append(0);

			sb.append(" ");
		}

		System.out.println(sb);
	}
}
