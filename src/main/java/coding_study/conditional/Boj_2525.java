package coding_study.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2525 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int c = Integer.parseInt(br.readLine());

		int allMin = a*60 + b + c;

		int hour = allMin / 60 >= 24 ? allMin/60-24 : allMin/60;
		int min = allMin % 60 ;

		StringBuilder sb = new StringBuilder();
		sb.append(hour+" "+min);
		System.out.println(sb);

	}
}
