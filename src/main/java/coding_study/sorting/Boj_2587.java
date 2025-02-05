package coding_study.sorting;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Boj_2587{
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();

		int sum = 0;
		for (int i = 0; i < 5; i++ ){
			list.add(Integer.parseInt(br.readLine()));
			sum += list.get(i);
		}

		Collections.sort(list);

		sb.append(sum/5).append("\n");
		sb.append(list.get(2)).append("\n");
		System.out.println(sb);


	}
}
