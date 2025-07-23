package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1822 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int[] arrA = new int[a];
		int[] arrB = new int[b];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < a; i++){
			arrA[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < b; i++){
			arrB[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arrA);
		Arrays.sort(arrB);

		int cnt = 0;

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < a; i++){
			int want = arrA[i];

			int left = 0;
			int right = b - 1;
			int mid = (left+right)/2;

			boolean check = false;

			while(left <= right){
				if( want > arrB[mid] ){
					left = mid + 1;
				}else if( want < arrB[mid] ){
					right = mid  - 1;
				}else{
					check = true;
					break;
				}
				mid = (left+right)/2;
			}

			if( !check ){
				cnt ++;
				sb.append(want).append(" ");
			}

		}

		System.out.println(cnt == 0 ? 0 : cnt +"\n" + sb);
	}
}
