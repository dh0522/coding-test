package programmers.second;

import java.util.LinkedList;
import java.util.Queue;

public class Prg_60057 {
	public static void main(String[] args) {
		Prg_60057 sol = new Prg_60057();

		System.out.println(sol.solution("aabbaccc"));
		System.out.println(sol.solution("ababcdcdababcdcd"));
		System.out.println(sol.solution("abcabcdede"));
		System.out.println(sol.solution("abcabcabcabcdededededede"));
	}

	private static int solution (String s){
		int ans = s.length();

		String newS = "";

		for(int len = s.length()/2; len >= 1; len --){

			String answer = "";
			Queue<String> q = new LinkedList<>();
			String tmp = "";
			newS = s;

			while( newS.length() > 0){

				if( newS.length() <= len ){
					q.add(newS);
					break;
				}
				tmp = newS.substring(0,len);
				newS = newS.substring(len);
				q.add(tmp);
			}

			boolean check = false;
			int count = 1;
			tmp = q.poll();
			answer += tmp;

			while( !q.isEmpty() ){
				if( !tmp.equals(q.peek()) ){
					if(check)
						answer += count;
					check = false;
					count = 1;

					tmp = q.poll();
					answer += tmp;
				}else{
					check = true;
					count++;
					tmp = q.poll();
				}
			}

			if(check){
				answer += count;
			}

			ans = Math.min(ans, answer.length());

		}



		return ans;
	}
}
