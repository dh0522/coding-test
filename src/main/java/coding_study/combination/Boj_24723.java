package coding_study.combination;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_24723 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		System.out.println((int)Math.pow(2,n));

	}
}
