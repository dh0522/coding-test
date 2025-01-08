package coding_study.setmap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_7785 {
	public static void main(String[] args) throws Exception {

		// set 은 정렬이 안돼  ,,
		String name = "";
		StringTokenizer st;
		String inandout = "";
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();


		while(n-- > 0){
			st  = new StringTokenizer(br.readLine());

			name = st.nextToken();
			inandout = st.nextToken();

			if( inandout.equals("enter") )
				set.add(name);
			else {
				set.remove(name);
			}
		}

		List<String> list = new ArrayList<>(set);
		Collections.sort( list, Collections.reverseOrder() );

		for( String str: list )
			sb.append(str).append("\n");

		System.out.println( sb );
	}
}
