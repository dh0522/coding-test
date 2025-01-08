package coding_study.setmap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_10816 {
	public static void main(String[] args) throws Exception {

		int n = 0;
		int m = 0;
		int card = 0;
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Integer> hm = new HashMap<>();
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in ));

		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while( n-- > 0){
			card = Integer.parseInt( st.nextToken() );
			hm.put( card, hm.getOrDefault( card , 0 ) + 1);
		}

		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while(m-- >0){
			card = Integer.parseInt( st.nextToken() );
			sb.append( hm.getOrDefault(card,0) ).append(" ");
		}

		System.out.println(sb);
	}
}
