package coding_study.twodimarray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2566 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int max = Integer.MIN_VALUE;
		int x =0;
		int y =0;
		int num;

		for (int i=0; i <9; i++ ){
			st = new StringTokenizer(br.readLine());
			for (int j=0; j < 9; j ++ ){
				num = Integer.parseInt(st.nextToken());

				if( max < num ){
					max = num;
					x = i+1;
					y = j+1;
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		sb.append(max).append("\n");
		sb.append(x+" "+y);

		System.out.println(sb);


	}
}
