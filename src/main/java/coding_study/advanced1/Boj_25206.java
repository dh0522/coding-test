package coding_study.advanced1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_25206 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
														// 0 	1   2    3    4    5    6    7    8
		List<String> list = new ArrayList<>(Arrays.asList("F","D0","D+","C0","C+","B0","B+","A0","A+"));
		double answer = 0;
		double sum = 0;

		for (int i=0; i < 20; i++ ){
			st = new StringTokenizer(br.readLine());

			String subject = st.nextToken();
			double grade = Double.parseDouble(st.nextToken());
			String score = st.nextToken();


			if( score.equals("P") )
				continue;
			sum += grade;
			if( score.equals("F") )
				continue;

			double scoNum = list.indexOf(score)*0.5 + 0.5;
			answer += scoNum*grade;

		}
		System.out.printf("%.6f%n", answer / sum);
	}

}
