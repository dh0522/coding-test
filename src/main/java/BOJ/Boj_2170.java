package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_2170 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		List<int[]> list = new ArrayList<>();

		for (int i=0;i <n; i++ ){
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());

			list.add( new int[] { first, second } );
		}

		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o2[1]-o1[1];
				else return o1[0]-o2[0];
			}
		});


		int nowX = list.get(0)[0];
		int nowY = list.get(0)[1];
		int answer = nowY - nowX ;

		for (int i=1; i < list.size(); i++ ){
			if ( nowX <= list.get(i)[0] && list.get(i)[1] <= nowY ){
				continue;
			}
			else if( list.get(i)[0] < nowY ){
				answer += list.get(i)[1] - nowY;
			}else{
				answer += list.get(i)[1] - list.get(i)[0];
			}

			nowX = list.get(i)[0];
			nowY = list.get(i)[1];
		}

		System.out.println(answer);

	}
}
