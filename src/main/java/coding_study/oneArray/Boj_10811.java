package coding_study.oneArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10811 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		for (int i =0; i < n; i++ )
			arr[i] = i+1;

		int x,y,tmp;
		for (int i =0; i <m; i++ ){
			st = new StringTokenizer(br.readLine());

			x = Integer.parseInt(st.nextToken())-1;
			y = Integer.parseInt(st.nextToken())-1;

			while( x < y ){
				tmp = arr[x];
				arr[x] = arr[y];
				arr[y] = tmp;
				x++;
				y--;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i : arr) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);



	}
}
