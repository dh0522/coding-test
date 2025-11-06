package BOJ.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_6064 {
	static int answer;
	public static void main(String[] args) throws IOException {

		///  달력
		//   x,y <= m,n 에 대해 각 년도를 <x:y> 로 펴현하였다.
		// 이세상의 시초에 해당하는 첫번째 해를 <1:1> 두번째해를 <2:2>
		///  m 과 n 의 차이만큼 밀리기 시작함
		// 1:1 2:2 3:3 4:4 5:5 6:6 7:7 8:8 9:9 10:10
		// 1:11 2:12 3:1 4:2 5:3 6:4 7:5 8:6 9:7 10:8
		// 1:9 2:10 3:11 4:12 5
		// 1:7 2:8 3:9
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++){
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			answer = -1;

			int lcm = m * n / gcd(m,n);





			sb.append(answer);
			sb.append("\n");
		}

		System.out.println(sb);

	}


	private static int gcd(int m, int n){
		if ( n == 0 ){
			return m;
		}
		else return gcd(n, m%n);
	}
}
