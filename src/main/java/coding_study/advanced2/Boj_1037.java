package coding_study.advanced2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
public class Boj_1037 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		List<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++ ){
			list.add( Integer.parseInt(st.nextToken() ));
		}

		Collections.sort(list);
		System.out.println(list.get(0)*list.get(list.size()-1));

	}
}
