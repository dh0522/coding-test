package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj_7785 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader( System.in ));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		Set<String> set = new HashSet<>();

		while( n-- > 0 ) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String log = st.nextToken();

			if (log.equals("enter")) {
				set.add(name);
			} else
				set.remove(name);

		}
		List<String> list = new ArrayList<>(set);
		list.sort(Comparator.reverseOrder());

		StringBuilder sb = new StringBuilder();
		for( int i= 0; i < list.size() ;i ++ )
			sb.append(list.get(i) +"\n" );
		System.out.println(sb);
	}
}
