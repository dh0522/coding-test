package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_1620 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt( st.nextToken());
		int m = Integer.parseInt( st.nextToken() );

		//  2 <= 포켓몬 이름 길이 <= 20
		// 총 m개의 줄에 내가 맞춰야 하는 문제가 입력으로 들어와

		HashMap<Integer , String> hm = new HashMap<>();
		HashMap<String , Integer > hm2 = new HashMap<>();

		int idx = 0;
		while( n-- > 0 ){
			String poket = br.readLine();
			hm.put(idx+1 , poket );
			hm2.put( poket , idx+1 );
			idx++;
		}
		StringBuilder sb = new StringBuilder();
		while( m-- > 0 ){

			String now = br.readLine();
			if( Character.isDigit( now.charAt(0) ) ){
				sb.append( hm.get(Integer.parseInt(now)) +" \n");

			}else{
				sb.append( hm2.get(now) +"\n" );
			}
		}

		System.out.println(sb);
	}
}
