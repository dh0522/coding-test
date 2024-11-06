package programmers.second;

import java.util.HashSet;
import java.util.Set;

public class Prg_49994 {
	public static void main(String[] args) {
		Prg_49994 sol = new Prg_49994();
		System.out.println(sol.solution("ULURRDLLU"	));
		System.out.println(sol.solution("LULLLLLLU"));
	}

	private static int solution( String dirs ){
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};

		Set<String> set = new HashSet<>();

		char[] dir = dirs.toCharArray();
		int x = 5;
		int y = 5;

		for( char ch : dir ){

			int d = -1;
			switch( ch ){
				case 'U':
					d = 0;
					break;
				case 'D':
					d = 1;
					break;
				case 'R':
					d = 2;
					break;
				case 'L':
					d = 3;
					break;
			}

			int nx = x + dx[d];
			int ny = y + dy[d];

			if( nx < 0 || ny < 0 || nx >= 11 || ny >= 11 )
				continue;

			StringBuilder sb = new StringBuilder();
			sb.append( Math.min(x,nx) ).append( Math.max( x,nx) ).append( Math.min(y,ny) ).append(Math.max(y,ny));



			set.add( sb.toString() );

			x = nx;
			y = ny;

		}

		return set.size();
	}
}
