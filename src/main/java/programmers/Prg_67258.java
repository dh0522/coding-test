package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Prg_67258 {
	public static void main(String[] args) {
		Prg_67258 sol = new Prg_67258();

		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };
		int[] answer = sol.solution( gems );
		for( int i : answer )
			System.out.print(i +" ");
		System.out.println();
	}
	private int[] solution( String[] gems ){

		// 보석 중복없는 개수
		Set<String> set = new HashSet<>();
		for( String gem : gems ){
			set.add(gem);
		}

		HashMap<String, Integer> hm = new HashMap<>();
		Queue<String> q = new LinkedList<>();

		int start = 0;
		int len = gems.length;
		int tempstart = 0;

		for( int i = 0 ; i < gems.length; i ++ ){

			hm.put( gems[i] , hm.getOrDefault( gems[i] , 0) +1 );
			q.add( gems[i] );

			while(true){

				String temp = q.peek();

				if( hm.get(temp) > 1 ){

					hm.put( temp , hm.get(temp) -1 );
					q.poll();
					tempstart++;
				}else break;

			}
			if( hm.size() == set.size() && q.size() < len ){
				start = tempstart;
				len = q.size();
			}

		}

		return new int[]{start+1, start+len};


	}
}
