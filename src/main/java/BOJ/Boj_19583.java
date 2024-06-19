package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj_19583 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String s = st.nextToken();
		String e = st.nextToken();
		String q = st.nextToken();

		Set<String> set =new HashSet<>();

		int ans = 0;
		String now ;

		while( (now = br.readLine()) != null ){
			String[] str = now.split(" ");
			if( now.isEmpty() )
				break;
			if( str[0].compareTo(s) <= 0 ){
				set.add(str[1]);
			}else if( e.compareTo(str[0]) <= 0 && str[0].compareTo(q) <= 0 && set.contains(str[1]) ){
				ans++;
				set.remove(str[1]);
			}
		}

		System.out.println(ans);
	}
}
