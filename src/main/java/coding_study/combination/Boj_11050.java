package coding_study.combination;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11050 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int mom = 1;
		for(int i = 0; i < k; i++ ){
			mom *= n--;
		}

		for(int i = 1; i <= k; i++ ){
			mom /= i;
		}

		System.out.println(mom);
	}
}
