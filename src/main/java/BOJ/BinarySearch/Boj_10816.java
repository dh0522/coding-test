package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0; i < n; i++ ){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		while(m-- > 0){

			int want = Integer.parseInt(st.nextToken());
			int low = lowbound(arr, want);
			int high = upperbound(arr,want);


			sb.append(high-low+1).append(" ");

		}

		System.out.println(sb);
	}
	private static int lowbound(int[] arr, int want){

		int left = 0;
		int right = arr.length-1;
		int mid = (left+right) / 2;

		while(left <= right){
			// want 보다 크거나 같다면, 조건을 만족하는 첫번재 원소를 찾는 것이므로
			// 왼쪽으로 좁혀나가기
			if( arr[mid] >= want){
				right =  mid -1;
			}
			// want보다 작다면
			else{
				left = mid + 1;
			}
			mid = (left+ right)/2;
		}

		return left;


	}
	private static int upperbound(int[] arr, int want){

		int left = 0;
		int right = arr.length-1;
		int mid = (left+right) / 2;

		while(left <= right){
			// want 보다 크거나 같다면, 조건을 만족하는 첫번재 원소를 찾는 것이므로
			// 왼쪽으로 좁혀나가기
			if( arr[mid] > want){
				right =  mid -1;
			}
			// want보다 작다면
			else{
				left = mid + 1;
			}
			mid = (left+ right)/2;
		}

		return right;
	}
}
