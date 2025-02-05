package coding_study.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Boj_10989{
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		for (int i = 0; i < n; i++ ){
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for( int i: arr )
			sb.append(i).append("\n");

		System.out.println(sb);
	}
}
