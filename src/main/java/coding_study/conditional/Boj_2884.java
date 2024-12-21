package coding_study.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2884 {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int allMin = x*60 + y -45;
		if( allMin < 0 )
			allMin += 24*60;
		int hour = allMin / 60;
		int min = allMin % 60;

		System.out.println(hour+" "+ min);

	}
}
