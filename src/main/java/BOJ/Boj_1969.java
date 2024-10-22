package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1969 {
	public static void main(String[] args) throws Exception  {

		BufferedReader br = new BufferedReader( new InputStreamReader(System.in ));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<String> list = new ArrayList<>();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for ( int i =0; i < n ; i++ ){
			list.add( br.readLine() );
		}

		String answer = "";
		int count = 0;
		for ( int i = 0; i < m ;i ++ ){

			int[] arr = new int[4];
			for ( int j =0 ; j < n; j++ ){
				char ch = list.get(j).charAt(i);

				switch (ch){
					case 'A':
						arr[0]++;
						break;
					case 'C':
						arr[1]++;
						break;
					case 'G':
						arr[2]++;
						break;
					case 'T':
						arr[3]++;
						break;
				}
			}

			int max = -1;
			int idx = -1;
			for ( int j = 0; j < 4; j++ ){
				if( max < arr[j] ){
					max = arr[j];
					idx = j;
				}
			}

			switch ( idx ){
				case 0:
					answer += "A";
					break;
				case 1:
					answer += "C";
					break;
				case 2:
					answer += "G";
					break;
				case 03:
					answer += "T";
					break;
			}

			count += ( n- max );

		}

		StringBuilder sb = new StringBuilder();
		sb.append(answer).append("\n").append(count);
		System.out.println(sb);
	}

}
