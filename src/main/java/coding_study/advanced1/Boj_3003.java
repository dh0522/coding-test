package coding_study.advanced1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_3003 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] chess = {1,1,2,2,2,8};
		StringBuilder sb = new StringBuilder();

		for (int i = 0 ; i < 6; i ++ ){
			int num = Integer.parseInt(st.nextToken());
			sb.append(chess[i]-num).append(" ");
		}
		System.out.println(sb);

	}
}

