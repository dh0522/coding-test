package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj_18870 {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		Set<Integer> set = new HashSet<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++ ){
			arr[i] = Integer.parseInt(st.nextToken());
			set.add(arr[i]);
		}

		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);

		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < n; i++){
			sb.append(getIndex(arr[i], list)).append(" ");
		}

		System.out.println(sb);
	}
	private static int getIndex(int want, List<Integer> arr){
		int left = 0;
		int right = arr.size() -1;
		int mid = (left + right)/2;

		while (left <= right){
			if(arr.get(mid) < want) {
				left = mid + 1;
			}else if(arr.get(mid) >= want){
				right = mid - 1;
			}

			mid = (left+right)/2;
		}

		return left;
	}
}
