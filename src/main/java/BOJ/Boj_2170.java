package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_2170 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		int answer = 0;

		List<int[]> list = new ArrayList<>();

		for (int i=0;i <n; i++ ){
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());

			boolean include = false;

			for (int j = 0; j < list.size() ; j++ ){

				int[] temp = list.get(j);

				if ( temp[0] <= first && second <= temp[1] ){
					include = true;

				}else if( first < temp[0]  && second <= temp[1] ){
					int diff = temp[0] - first;
					answer += diff;

					list.remove(j);

					list.add( new int[]{ first, temp[1] } );
					include = true;

				}else if( temp[0] <= first && first <= temp[1] && temp[1] < second ){

					int diff = second - temp[1];
					list.remove(j);
					list.add( new int[]{temp[0] , second });

					answer += diff;
					include = true;

				}

				if ( include )
					break;
			}

			if (!include){

				list.add( new int[]{first,second});
				answer += second-first;
			}



		}


		System.out.println(answer);

	}
}
