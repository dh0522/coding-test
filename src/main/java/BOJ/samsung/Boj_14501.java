package BOJ.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14501 {
	private static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] money = new int[n];
		int[] time = new int[n];


		StringTokenizer st;
		for (int i=0; i< n; i++){
			st = new StringTokenizer(br.readLine());

			time[i] = Integer.parseInt(st.nextToken());
			money[i] = Integer.parseInt(st.nextToken());

		}

		dfs( n, 0 , 0, time, money);

		System.out.println(answer);

	}
	private static void dfs(int n, int nowDay, int sum, int[] time, int[] money){
		if (nowDay > n)
			return;
		answer = Math.max(answer, sum);

		for (int i = nowDay; i < n; i++){
			if ( i + time[i] > n )
				continue;
			dfs(n, i+time[i], sum+money[i], time, money);
		}
	}

}
