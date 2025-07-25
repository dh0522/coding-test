package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2805 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] tree = new int[n];

		st = new StringTokenizer(br.readLine());

		long left = 0;
		long right = 0;

		for(int i = 0; i < n; i ++){
			tree[i] = Integer.parseInt(st.nextToken());
			right = Math.max( tree[i], right);
		}


		long max = 0;

		while(left <= right){

			long mid = (left+ right)/2;

			long sum = 0;
			for(int i = 0; i < n; i++ ){
				if(tree[i] > mid)
					sum += (tree[i] - mid);
			}


			if(sum >= m){
				max = mid;
				left = mid + 1;
			}else{
				right = mid - 1;
			}

		}

		System.out.println(max);


	}
}
