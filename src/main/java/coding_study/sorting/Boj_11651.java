package coding_study.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj_11651 {
	public static void main(String[] args) throws Exception{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][2];
		for (int i =0; i <n; i++ ){
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort( arr, new Comparator<>(){
			@Override
			public int compare( int[] o1, int[] o2 ){
				if( o1[1] == o2[1] )
					return o1[0] - o2[0];
				return o1[1] - o2[1];

			}
		});

		StringBuilder sb = new StringBuilder();
		for (int[] i: arr){
			sb.append(i[0]).append(" ").append(i[1]).append("\n");
		}
		System.out.println(sb);

	}
}
