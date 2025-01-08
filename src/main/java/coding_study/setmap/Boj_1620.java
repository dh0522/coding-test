package coding_study.setmap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_1620 {
	public static void main(String[] args) throws Exception {

		// 시간 초과 발생 !!
		int n = 0;
		int m = 0;
		int idx = 1;
		String name = "";
		StringBuilder sb = new StringBuilder();
		HashMap<String,Integer> hm = new HashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine() );

		n = Integer.parseInt( st.nextToken() );
		m = Integer.parseInt( st.nextToken() );
		String[] getIntKey = new String[n+1];

		while( n-- > 0 ){
			name = br.readLine();
			getIntKey[idx] = name;
			hm.put( name, idx++ );
		}


		// keySet 으로 list 만들면 순서가 변경되서 들어가서 안돼
		// keySet = string
		while(m-- > 0){
			name = br.readLine();

			if( Character.isDigit(name.charAt(0)) ){
				sb.append( getIntKey[Integer.parseInt(name)] ).append("\n");
			}else{
				sb.append(hm.get(name)).append("\n");
			}
		}

		System.out.println(sb);


	}
}
