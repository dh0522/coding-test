package coding_study.advanced2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj_26069 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Set<String> set = new HashSet<>();
		StringTokenizer st;

		while(n-- > 0){
			st = new StringTokenizer(br.readLine());
			String first = st.nextToken();
			String second = st.nextToken();

			if( first.equals("ChongChong") || second.equals("ChongChong") ){
				set.add(first);
				set.add(second);
			}else if( set.contains(first) ){
				set.add(second);
			}else if( set.contains(second) ){
				set.add(first);
			}

		}
		System.out.println(set.size());
	}
}
