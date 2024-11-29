package programmers.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prg_42888 {
	public static void main(String[] args) {
		Prg_42888 sol = new Prg_42888();
		System.out.println(Arrays.toString( sol.solution( new String[]{  "Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan" })));
	}
	private static String[] solution( String[] record ){
		List<String> list = new ArrayList<>();

		// 먼저 id를
		Map<String, String> hm = new HashMap<>();
		for( int i =0; i < record.length; i++ ){

			if( record[i].charAt(0) == 'L' )
				continue;

			String[] tmp = record[i].split(" ");
			hm.put( tmp[1] , tmp[2] ) ;
		}

		for( int i =0; i < record.length; i++ ){

			if( record[i].charAt(0) == 'C' )
				continue;

			if( record[i].charAt(0) == 'E' ){
				String[] tmp = record[i].split(" ");
				String name = hm.get(tmp[1])+"님이 들어왔습니다.";

				list.add( name );
			}else{
				String[] tmp = record[i].split(" ");
				String name = hm.get(tmp[1])+"님이 나갔습니다.";

				list.add(name);
			}

		}

		return list.toArray(new String[list.size()]);
	}
}
