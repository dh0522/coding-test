package coding_study.oneArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10810 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n+1];
		int x,y,z;

		for (int i=0; i < m; i ++ ){
			st = new StringTokenizer(br.readLine());

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());

			for( int j = x ; j <= y ; j ++ ){
				arr[j] = z;
			}

		}

		for (int i =1 ; i <= n; i++ ){
			System.out.print(arr[i]+" ");
		}

	}
}
