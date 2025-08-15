package BOJ.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_15686 {
	static int n,m;
	static List<int[]> chicken = new ArrayList<>();
	static List<int[]> home = new ArrayList<>();
	static boolean[] check;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());


		// 0 = 빈 칸, 1 = 집, 2 = 치킨집
		for (int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++){
				int num = Integer.parseInt(st.nextToken());
				if (num == 2){
					chicken.add(new int[]{i,j});
				}else if(num == 1){
					home.add(new int[]{i,j});
				}
			}
		}
		check = new boolean[chicken.size()];

		// 치킨집 개수 = m보다 크거나 같다.
		// 폐업시키지 않을 치킨집 최대 m개를 골랐을 때, 도시의 치킨거리의 최솟값을 출력
		dfs(0, 0);

		System.out.println(answer);
	}
	private static void dfs(int depth, int start){

		if (depth == m) {
			calc();
			return;
		}


		for (int i =start; i < check.length; i++){
			if (check[i])
				continue;

			check[i] = true;
			dfs(depth+1, i);
			check[i] = false;
		}

	}
	private static void calc(){

		int sum = 0;

		for (int[] house: home){
			int min = Integer.MAX_VALUE;

			for (int i = 0; i < chicken.size(); i++){

				if (check[i]){
					int tmp = Math.abs(house[0]-chicken.get(i)[0]) + Math.abs(house[1]-chicken.get(i)[1]);

					min = Math.min(min,tmp);
				}


			}
			sum += min;
		}

		answer = Math.min(sum, answer);

	}





}
