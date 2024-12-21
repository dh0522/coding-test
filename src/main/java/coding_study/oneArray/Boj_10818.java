package coding_study.oneArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10818 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int tmp;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i < n; i++){
			tmp = Integer.parseInt(st.nextToken());

			max = Math.max( max, tmp );
			min = Math.min(min, tmp);
		}

		System.out.println(min+" "+max);

	}
}
