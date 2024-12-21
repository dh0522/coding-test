package coding_study.oneArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_10811_2 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());


		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<Integer> list = new ArrayList<>();
		for (int i=0; i <n ; i++ )
			list.add(i+1);

		int x,y ;
		for (int i =0; i <m; i ++ ){
			st = new StringTokenizer(br.readLine());

			x = Integer.parseInt(st.nextToken())-1;
			y = Integer.parseInt(st.nextToken())-1;

			List<Integer> sub = list.subList(x,y+1);
			Collections.reverse( sub );
		}

		for (Integer i : list) {
			System.out.print(i+" ");
		}
 	}
}
