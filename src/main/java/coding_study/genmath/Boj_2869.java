package coding_study.genmath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2869 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		if( V < A ){
			System.out.println(1);
			return;
		}

		int oneDay = A-B;

		// 마지막날 제외 즉 A만큼 올라가고 그냥 끝나야 돼
		V -= A;

		int answer = V/oneDay+1;
		if ( V%oneDay != 0 )
			answer++;

		System.out.println(answer);

	}
}
