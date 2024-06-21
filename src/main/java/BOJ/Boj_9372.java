package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_9372 {
	public static void main(String[] args) throws  Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt( br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while( t-- > 0 ){
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] arr = new int[m][2];
			for( int i = 0 ; i < m; i++ ){
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());

			}
			sb.append(n-1+"\n");
		}
		System.out.println(sb);
	}
}
