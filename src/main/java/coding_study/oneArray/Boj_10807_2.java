package coding_study.oneArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10807_2 {
	public static void main(String[] args) throws Exception {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[n];
		for (int i =0; i <n; i ++ )
			arr[i] = Integer.parseInt(st.nextToken());

		int want = Integer.parseInt(br.readLine());

		System.out.println(Arrays.stream(arr).filter(x-> x == want).count() );
	}
}
