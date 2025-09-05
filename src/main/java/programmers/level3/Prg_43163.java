package programmers.level3;

public class Prg_43163 {
	public static void main(String[] args) {
		Prg_43163 sol = new Prg_43163();

		System.out.println(sol.solution("hit", "cog", new String[]{ "hot", "dot", "dog", "lot", "log", "cog" }));
		System.out.println(sol.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));

	}
	private static int answer = 0;
	private static int solution(String begin, String target, String[] words){

		answer = Integer.MAX_VALUE;
		if(isPossible(begin, target)){
			return 1;
		}

		for(int i = 0; i < words.length; i++){
			boolean[] check = new boolean[words.length];

			if(isPossible(begin, words[i])){
				check[i] = true;
				dfs(1, words[i], target, words, check);
			}
		}

		return answer == Integer.MAX_VALUE ? 0 : answer;
	}
	private static void dfs(int depth, String now, String target, String[] words, boolean[] check){
		if(now.equals(target)){
			answer = Math.min(answer, depth);
			return;
		}

		for(int i = 0; i < words.length; i++){
			if(check[i])
				continue;
			if( isPossible(now, words[i]) ){
				check[i] = true;
				dfs(depth+1, words[i], target, words, check);
				check[i] = false;
			}

		}


	}
	private static boolean isPossible(String a, String b){

		int cnt = 0;

		for(int i = 0; i < a.length(); i++ ){
			if(a.charAt(i) != b.charAt(i)){
				cnt++;

				if(cnt >= 2)
					return false;
			}
		}

		return true;

	}
}
