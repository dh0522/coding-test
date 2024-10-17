package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Boj_1244 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // 스위치 개수

		boolean[] button = new boolean[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i=1; i<=n ;i++ ){
			int temp = Integer.parseInt(st.nextToken());
			if ( temp == 1 )
				button[i] = true; // 켜짐:1 true , 꺼짐:0 false
			else button[i] = false;
		}

		int s = Integer.parseInt(br.readLine());
		int[][] student = new int[s][2];

		for (int i =0; i < s ; i++ ){
			st = new StringTokenizer(br.readLine());
			student[i][0] = Integer.parseInt(st.nextToken()); // 성별 = 남자 1, 여자 2
			student[i][1] = Integer.parseInt(st.nextToken()); // 학생이 받은 수

		}

		for ( int i =0; i < s ; i++ ){

			if ( student[i][0] == 1 ){
				// 남학생
				int studentNumber = student[i][1];

				for ( int j=1 ; j <= n; j++ ){
					if ( j%studentNumber == 0 ){
						button[j] = !button[j];
					}
				}
			}else{
				// 여학생
				int studentNumber = student[i][1];
				int ex = studentNumber;
				int post = studentNumber;

				while( true ){

					ex--;
					post++;

					if(  ex <= 0 || n < post )
						break;

					if ( button[ex] != button[post] )
						break;

					button[ex] = !button[ex];
					button[post] = !button[post];
				}
				button[studentNumber] = !button[studentNumber];

			}

		}

		StringBuilder sb = new StringBuilder();


		for ( int i= 1; i <=n ;i++ ){
			if (button[i])
				sb.append(1+" ");
			else sb.append(0+" ");

			if ( i%20 == 0 )
				sb.append("\n");
		}



		System.out.println(sb);

	}
}
