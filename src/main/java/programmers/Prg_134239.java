package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prg_134239 {
	public static void main(String[] args) {
		Prg_134239 sol = new Prg_134239();

		System.out.println(Arrays.toString(sol.solution(5, new int[][] {{0,0},{0,-1},{2,-3},{3,-3}})));
		System.out.println(Arrays.toString(sol.solution(3, new int[][] {{0,0},{1,-2},{3,-3}})));
	}

	private static double[] solution(int k, int[][] ranges) {
		double[] answer = new double[ranges.length];

		List<int[]> list = new ArrayList<>();
		int x = 0;

		while(true){
			int[] arr = {x,k};
			list.add( arr );

			if( k == 1 )
				break;

			x ++;

			if(k % 2 == 0){
				k/=2;
			}else
				k = k * 3 + 1;
		}

		int n = list.size() - 1;
		double all = 0;
		double[] integral = new double[n];

		for(int i = 0; i < n; i++){
			int[] first = list.get(i);
			int[] second = list.get(i+1);

			// 계수
			double coefficient =  (double)(second[1]-first[1]) / (second[0]-first[0]);
			double num = first[1] - coefficient*first[0];

			// 정적분 값 구하기
			double high = coefficient * second[0] * second[0] / 2 + num * second[0];
			double low = coefficient * first[0] * first[0] / 2 + num * first[0];
			integral[i] = high-low;
			all += integral[i];
		}


		for(int i = 0; i < ranges.length; i++){
			if(ranges[i][0] == 0 && ranges[i][1] == 0){
				answer[i] = all;
				continue;
			}

			int first = ranges[i][0];
			int second = n + ranges[i][1];

			if(first > second){
				answer[i] = -1.0;
				continue;
			}

			double sum = 0;
			for(int t = first; t < second; t++ ){
				sum += integral[t];
			}

			answer[i] = sum;

		}

		return answer;
	}
}
