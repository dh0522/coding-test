package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1920 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n 개의 정수 a1 ~ an 이 주어져 있을 때, 이안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[n];
		for(int i=0; i < n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		while(m-- > 0){
			int want = Integer.parseInt(st.nextToken());
			int left = 0;
			int right = n-1;
			int mid = (left+right)/2;

			boolean check = false;

			while(left <= right){

				if( arr[mid] == want){
					check = true;
					break;
				}

				if(arr[mid] < want){
					left = mid+1;
				}else if( arr[mid] > want){
					right = mid-1;
				}

				mid = (left+right)/2;
			}

			if(check)
				sb.append(1).append("\n");
			else sb.append(0).append("\n");

		}

		System.out.println(sb);


	}
}
