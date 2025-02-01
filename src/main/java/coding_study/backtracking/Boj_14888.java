package coding_study.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14888 {
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int[] arr;
	static int[] operator;
	public static void main(String[] args) throws Exception {

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		operator = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++){
			operator[i] = Integer.parseInt(st.nextToken());
		}

		search( arr[0] , 1 , n );
		StringBuilder sb = new StringBuilder();

		sb.append(max).append("\n").append(min);
		System.out.println(sb);
	}
	private static void search( int now, int depth, int n ){
		if (depth == n){
			max = Math.max(now, max);
			min = Math.min(now, min);
			return;
		}

		for(int i = 0; i < operator.length; i++ ){
			if (operator[i] == 0)
				continue;

			if ( i == 0 ){
				operator[i]--;
				search(now+arr[depth], depth+1, n );
				operator[i]++;
			}else if( i == 1 ){
				operator[i]--;
				search(now-arr[depth], depth+1, n );
				operator[i]++;
			}else if( i == 2 ){
				operator[i]--;
				search(now*arr[depth], depth+1, n );
				operator[i]++;
			}else{
				operator[i]--;
				search(now/arr[depth], depth+1, n );
				operator[i]++;
			}

		}
	}
}
