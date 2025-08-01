package BOJ.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_13458 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] space = new int[n];


		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i< n; i++){
			space[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());


		long ans = n;

		for(int i=0; i<n; i++){
			if(space[i] - b <= 0)
				continue;

			space[i] -= b;
			ans += (space[i]%c == 0 ? space[i] / c : space[i] / c + 1);
		}

		System.out.println(ans);


	}
}
