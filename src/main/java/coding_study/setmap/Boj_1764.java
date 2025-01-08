package coding_study.setmap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1764 {
	public static void main(String[] args) throws Exception{

		int n = 0;
		int m = 0;
		String name = "";
		Set<String> set = new HashSet<>();
		List<String> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt( st.nextToken() );
		m = Integer.parseInt( st.nextToken() );

		while(n-- > 0 ){
			set.add( br.readLine() );
		}

		int len = 0 ;
		while(m-- > 0){
			len = set.size();
			name = br.readLine();
			set.add(name);

			if( set.size() == len ){
				list.add( name );
			}
		}

		Collections.sort( list );
		sb.append(list.size()).append("\n");
		for(String str: list)
			sb.append(str).append("\n");

		System.out.println( sb );


	}
}
