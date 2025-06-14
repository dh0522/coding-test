package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Prg_181188 {
	public static void main(String[] args) {
		Prg_181188 sol = new Prg_181188();

		System.out.println(sol.solution(new int[][] {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}}));
	}
	private static int solution(int[][] targets ){
		int answer = 1;

		Arrays.sort( targets, new Comparator<>(){
			@Override
			public int compare(int[] a, int[] b){
				if(a[0] == b[0]){
					return a[1] - b[1];
				}
				return a[0] - b[0];
			}
		});

		int y = targets[0][1];

		for(int i=1; i < targets.length; i++){
			if(y <= targets[i][0]){
				answer++;
				y = targets[i][1];

			}else if( targets[i][1] < y ){
				y = targets[i][1];
			}

		}

		return answer;
	}
}
