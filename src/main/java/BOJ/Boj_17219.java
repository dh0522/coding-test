package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_17219 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		HashMap<String, String> hm = new HashMap<>();
		for( int i  = 0; i<  n; i++ ){
			st = new StringTokenizer(br.readLine());
			String site = st.nextToken();
			String pw = st.nextToken();

			hm.put( site, pw );
		}
		StringBuilder sb= new StringBuilder();
		for( int i = 0 ; i <m ; i ++ ){
			String now = br.readLine();
			sb.append( hm.get(now) +"\n" );
		}
		System.out.println(sb);
	}
}
