package coding_study.genmath;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_1193 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int tmpX = x;
		/**
		 *  1 =1/1
		 *  2 = 1/2 2/1
		 *  3 = 3/1 2/2 1/3
		 *  4 = 1/4 2/3 3/2 4/1
		 *  5 = 5/1 4/2 3/3 2/4 1/5
		 *  6
		 *  ..
		 *
		 */

		// 몇번째 줄인지
		int rowNum = 0;
		while( tmpX > 0 ){
			tmpX -= rowNum;
			rowNum++;
		}

		int son = 0;
		int mom = 0;
		int start = (rowNum-1)*rowNum/2;
		if ( rowNum % 2 == 0 ){
			while (true){
				son = rowNum;
				mom = rowNum;
			}
		}
	}
}
