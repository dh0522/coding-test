package coding_study.advanced2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Boj_25192 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> set = new HashSet<>();
		int n = Integer.parseInt(br.readLine());

		int answer = 0;
		while(n-- > 0){
			String str = br.readLine();
			if ( str.equals("ENTER") ){
				answer += set.size();
				set = new HashSet<>();
				continue;
			}
			set.add(str);
		}

		System.out.println(answer + set.size());

	}
}
