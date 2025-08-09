package BOJ.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14891 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 4개의 톱니바퀴 의 상태
		String[] wheel = new String[4];
		for (int i = 0; i < 4; i++){
			wheel[i] = br.readLine();
		}

		// 회전 횟수
		int k = Integer.parseInt(br.readLine());

		// K개 줄에는 회전시킨 방법
		// 두개의 정수 = 톱니바퀴 번호, 방향
		int[][] rotation = new int[k][2];


		// 맞닿아 있는 극이 다르다면, 반대방향으로 회전한다.
		// 극이 같다면, 회전하지 않는다.

		StringTokenizer st;
		for (int i = 0; i < k; i++){
			st = new StringTokenizer(br.readLine());
			rotation[i][0] = Integer.parseInt(st.nextToken());
			rotation[i][1] = Integer.parseInt(st.nextToken()); // 1 = 시계 , -1 = 반시계
		}

		for (int i = 0; i < k; i++ ){

			int num = rotation[i][0]; // 3
			int dir = rotation[i][1]; // -1

			String[] changeWheel;
			changeWheel = wheel.clone();

			// 먼저 num 톱니바퀴부터 회전
			turn(changeWheel, num-1, dir);

			int center = num-1;
			char ch = wheel[center].charAt(6);
			int tmpDir = dir;

			// 1. 왼쪽 방면
			while(--center >= 0){

				String now = wheel[center];
				if (now.charAt(2) == ch){
					break;
				}

				tmpDir *= -1;

				turn(changeWheel, center, tmpDir);
				ch = now.charAt(6);
			}

			// 2. 오른쪽 방면
			center = num - 1;
			ch = wheel[center].charAt(2);
			tmpDir = dir;

			while(++center < 4){
				String now = wheel[center];
				if (now.charAt(6) == ch){
					break;
				}

				tmpDir *= -1;

				turn(changeWheel, center, tmpDir);
				ch = now.charAt(2);

			}

			wheel = changeWheel.clone();

		}



		int answer = 0;

		for (int i =0 ; i < 4; i++ ){
			char ch = wheel[i].charAt(0);
			if (ch == '1') {
				answer += Math.pow(2, i);
			}
		}

		System.out.println(answer);

 	}
	 private static void turn(String[] arr, int idx,  int dir){

		String wheel = arr[idx];

		String str = "";
		// 시계 방향
		if(dir == 1 ){
			str += wheel.charAt(7) + wheel.substring(0,7);
		}else{
			// 반시계 방향
			str += wheel.substring(1) + wheel.charAt(0);
		}

		arr[idx] = str;

	 }
}



