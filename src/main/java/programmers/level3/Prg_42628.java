package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Prg_42628 {
	public static void main(String[] args) {
		Prg_42628 sol = new Prg_42628();

		System.out.println(Arrays.toString(sol.solution(new String[]{ "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" })));
		System.out.println(Arrays.toString(sol.solution(new String[]{ "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333" })));
	}

	private static int[] solution(String[] operations){

		List<Integer> list = new ArrayList<>();


		for(String operation: operations){

			String oper = operation.split(" ")[0];
			int num = Integer.parseInt(operation.split(" ")[1]);

			if(oper.equals("I")){
				list.add(num);
				Collections.sort(list);

			}else if(list.size() > 0){

				if(num == 1){
					list.remove(list.size()-1);
				}else{
					list.remove(0);
				}
			}
		}

		if(list.size() == 0)
			return new int[]{0,0};

		return new int[] { list.get( list.size() -1 ), list.get( 0 )  };
	}
}
