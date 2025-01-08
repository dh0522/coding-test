package coding_study.setmap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj_14425 {
	public static void main(String[] args) throws Exception {

		int n,m;
		int answer =0;
		Set<String> set = new HashSet<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine() );
		n = Integer.parseInt( st.nextToken() );
		m = Integer.parseInt( st.nextToken() );

		while( n-- > 0 ){
			set.add(br.readLine());
		}

		while( m-- > 0 ){
			if( set.contains( br.readLine()) )
				answer++;
		}

		System.out.println(answer);
	}
}
