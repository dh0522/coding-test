package coding_study.advanced1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Boj_2941 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> list = new ArrayList<>(Arrays.asList("c=","c-","dz=","d-","lj","nj","s=","z="));

		String str = br.readLine();

		for (String s : list) {
			if ( str.contains(s) )
				str = str.replaceAll(s,",");
		}

		System.out.println(str.length());
	}
}
