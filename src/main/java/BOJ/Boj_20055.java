package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_20055 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[2*n];
		boolean[] robot = new boolean[n];

		st = new StringTokenizer(br.readLine());
		for( int i = 0 ; i < 2*n;  i++ ){
			arr[i] = Integer.parseInt(st.nextToken());
 		}

		int stage = 0;
		int zeroNum = 0;

		while( zeroNum < k ){

			zeroNum = 0;
			stage++;

			// 벨트가 각 칸에 있는 로봇과 함께 회전

			int tmp = arr[2*n-1];
			for( int i = 2*n - 1 ; i > 0; i-- ){
				arr[i] = arr[i-1];
			}
			arr[0] = tmp;

			for(int i= n-1; i > 0 ; i-- ){
				robot[i] = robot[i-1];
			}

			robot[0] = false;
			robot[n-1] = false;

			// 가장 먼저 벨트에 올라간 애부터 한 칸 이동.
			for( int i = n-2; i >= 0 ; i-- ){
				if( robot[i] && !robot[i+1] && arr[i+1] >= 1 ){

					robot[i] = false;
					robot[i+1] = true;
					arr[i+1]--;

					if( i+1 == n-1 )
						robot[i+1] = false;
				}
			}

			// 올리는 위치에 내구도가 0이 아니면 로봇올리기
			if( arr[0] != 0 ){
				robot[0] = true;
				arr[0]--;
			}

			// 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료
			for( int i =0 ; i <2*n; i++ ){
				if( arr[i] == 0 )
					zeroNum++;
			}

		}

		System.out.println(stage);
	}
}
