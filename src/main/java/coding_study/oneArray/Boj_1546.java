package coding_study.oneArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1546 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();

		int num;
		int max = 0;
		for (int i=0; i< n; i ++ ){
			num = Integer.parseInt(st.nextToken());
			max = Math.max(num,max);
			list.add(num);
		}


		double answer = 0;
		for (int i=0 ; i<n; i++ ){
			answer +=(double) list.get(i) /max*100;
		}

		System.out.println(answer/n);
	}

}
