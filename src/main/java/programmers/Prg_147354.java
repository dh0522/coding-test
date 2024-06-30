package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Prg_147354 {
	public static void main(String[] args) {

		Prg_147354 sol = new Prg_147354();
		int result = sol.solution( new int[][] {{2,2,6},{1,5,10},{4,2,9},{3,8,3}}, 2,2,3);

		System.out.println(result);
	}
	public static int solution(int[][] data ,int col , int row_begin, int row_end ){

		Arrays.sort( data , new Comparator<int[]>(){
			@Override
			public int compare( int[] o1 , int[] o2 ){
				if( o1[col-1] != o2[col-1] )
					return o1[col-1] - o2[col-1];
				return o2[0]-o1[0];
			}
		});

		int answer = 0;
		for( int i = row_begin-1;i < row_end; i++ ){
			int num = i+1;
			int sum = 0;
			for( int j = 0 ;j < data[0].length; j++ ){
				sum += (data[i][j]%num);
			}
			answer = answer^sum;
		}
		return answer;
	}
}
