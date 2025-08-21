package BOJ.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_17140 {
	static int r, c, k;
	static int[][] arr;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken())-1;
		c = Integer.parseInt(st.nextToken())-1;
		k = Integer.parseInt(st.nextToken());

		arr = new int[100][100];

		for (int i = 0; i < 3; i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if (arr[r][c] == k){
			System.out.println(0);
			return;
		}

		// r = 배열 A 의 모든 행에 대해서 정렬을 수행한다. 행의 개수 >= 열의 개수
		// c = 배열 A의 모든 열에 대해서 정렬을 수행한다. 행의 개수 < 열의 개수


		// 한 행 또는 열에 있는 수를 정렬하려면


		// a[r][c] == k 인지
		int maxRow = 3;
		int maxColumn = 3;
		int answer = 0;
		while(arr[r][c] != k) {
			if (answer > 100)
				break;

			if (maxRow >= maxColumn) {
				// 모든 행에 대한 정렬 수행
				for (int i = 0; i < maxRow; i++) {
					maxColumn = Math.max(maxColumn, sortRow(i));
				}
			} else {
				// 모든 열에 대한 정렬 수행
				for (int i = 0; i < maxColumn; i++) {
					maxRow = Math.max(maxRow, sortColumn(i));
				}
			}

			answer++;

		}

		System.out.println(answer == 101 ? -1 : answer);
	}

	private static int sortRow(int row){
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr[row].length; i++){
			if (arr[row][i] == 0)
				continue;

			map.put(arr[row][i], map.getOrDefault(arr[row][i] , 0)+1 );
			arr[row][i] = 0;
		}


		List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
		entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2 ){
				if (o1.getValue() == o2.getValue())
					return o1.getKey() - o2.getKey();
				return o1.getValue() - o2.getValue();
			}
		} );

		int col = 0;
		for (int i = 0; i < entryList.size(); i++){
			arr[row][col++] = entryList.get(i).getKey();
			arr[row][col++] = entryList.get(i).getValue();
		}



		return col;
	}
	private static int sortColumn(int column){

		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++){
			if (arr[i][column] == 0)
				continue;
			map.put(arr[i][column], map.getOrDefault(arr[i][column], 0)+1);
			arr[i][column] = 0;
		}



		List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
		entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2 ){
				if (o1.getValue() == o2.getValue())
					return o1.getKey() - o2.getKey();
				return o1.getValue() - o2.getValue();
			}
		} );

		int row = 0;
		for (int i = 0; i < entryList.size(); i++){
			arr[row++][column] = entryList.get(i).getKey();
			arr[row++][column] = entryList.get(i).getValue();
		}
		return row;
	}


}
