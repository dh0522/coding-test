package programmers.second;

import java.util.Arrays;

public class Prg_68936 {
	public static void main(String[] args) {

		Prg_68936 sol = new Prg_68936();

		System.out.println( Arrays.toString(sol.solution( new int[][]{ { 1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1 } })));
	}
	private static boolean[][] check;
	private static int[] answer = new int[2];
	private static int[] solution ( int[][] arr ){

		int length = arr.length;
		check = new boolean[arr.length][arr[0].length];

		for( int i = 0; i < arr.length; i++ ){
			for( int j = 0;j < arr.length; j++ ){
				answer[arr[i][j]]++;
			}
		}


		while( length != 1 ){

			for( int i = 0; i <= arr.length - length; i += length ){
				for( int j = 0; j <= arr[0].length - length; j += length ){
					if( check[i][j] )
						continue;
					pressure(arr, length, i, j);
				}
			}

			length /= 2;

		}

		return answer;
	}
	private static void pressure( int[][] arr, int length, int x, int y){

		for( int i = x; i < x + length; i ++ ){
			for( int j = y; j < y + length; j ++ ){
				if( arr[i][j] != arr[x][y] )
					return;
			}
		}


		// 다 동일함
		for( int i = x; i < x + length; i++ ){
			for(int j = y; j < y + length; j++ ){
				check[i][j] = true;
			}
		}

		answer[arr[x][y]] -= (length*length) - 1;

	}
}


