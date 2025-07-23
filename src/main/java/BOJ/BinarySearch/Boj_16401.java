package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_16401 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[] len = new int[n];
		st = new StringTokenizer(br.readLine());

		for (int i=0; i <n; i++){
			len[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(len);

		int left = 1;
		int right = len[n-1];

		while(left <= right){
			int mid = (left + right)/2;
			int cnt = 0;

			for (int i = 0; i < n; i++){
				if (len[i] >= mid){
					cnt += len[i]/mid;
				}
			}

			if (cnt >= m){
				left = mid + 1;
			}else {
				right = mid -1;
			}

		}

		System.out.println(right);

	}

}
