package coding_study.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_10814 {
	public static void main(String[] args) throws Exception {

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		List<Member> list = new ArrayList<>();

		for ( int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();

			list.add( new Member(age, name,i) );
		}

		Collections.sort(list);

		StringBuilder sb = new StringBuilder();
		for(Member member: list){
			sb.append(member.age).append(" ").append(member.name).append("\n");
		}
		System.out.println(sb);

	}
}

class Member implements Comparable<Member> {
	int age;
	String name;
	int idx;

	public Member( int age, String name, int idx ){
		this.age = age;
		this.name = name;
		this.idx = idx;
	}

	public int compareTo(Member member){
		if (member.age == this.age)
			return this.idx - member.idx;
		return this.age - member.age;
	}
}
