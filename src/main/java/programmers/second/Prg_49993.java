package programmers.second;

import java.util.ArrayList;
import java.util.List;

public class Prg_49993 {
	public static void main(String[] args) {
		Prg_49993 sol = new Prg_49993();
		System.out.println(sol.solution( "CBD", new String[]{ "BACDE", "CBADF", "AECB", "BDA"  }));
	}

	private static int solution( String skill , String[] skill_trees ){

		List<Character> list = new ArrayList<>();
		for( int i=0 ; i < skill.length(); i ++ ){
			list.add( skill.charAt(i) );
		}

		int answer = 0;

		for( String now: skill_trees ){

			int idx = 1;
			boolean check = true;

			for( int i =0; i < now.length() ; i++ ){
				if( list.contains( now.charAt(i) ) ){
					int nowIdx = list.indexOf( now.charAt(i) ) + 1;
					if( nowIdx != idx ){
						check = false;
						break;
					}
					idx++;
				}

				if( !check )
					break;
			}

			if( check )
				answer++;
		}

		return answer;
	}
}
