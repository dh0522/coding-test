package coding_study.oneArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10871 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 정수 n개로 이루어진 수열 A와 정수 x가 주어진다.
		// 이때 A에서 x보다 작은수를 모두 출력해라.
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int num;

		StringBuilder sb = new StringBuilder();

		for (int i=0; i <n; i++ ){
			num = Integer.parseInt(st.nextToken());
			if ( num < x )
				sb.append(num).append(" ");
		}
		System.out.println(sb);
	}
}
