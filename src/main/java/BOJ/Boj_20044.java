package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_20044 {
	public static void main(String[] args) throws Exception {

		/**
		 *	프로젝트 팀 하나는 2명의 학생으로 구성
		   	각 학생은 한 팀의 팀원이어야 한다.
		 	팀원 코딩 역량의 합을 일정하게 유지하려 한다.
		 */

		BufferedReader br = new BufferedReader( new InputStreamReader( System. in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] people = new int[2*n];
		for ( int i=0; i < 2*n; i++ ){
			people[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort( people );

		int answer = Integer.MAX_VALUE;
		for ( int i = 0; i < n; i++ ){
			int temp = people[i] + people[2*n-1-i ];
			answer = Math.min( answer , temp );
		}

		System.out.println(answer);
	}
}
