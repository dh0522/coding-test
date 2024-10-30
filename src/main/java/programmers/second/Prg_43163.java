package programmers.second;

public class Prg_43163 {
	public static void main(String[] args) {
		Prg_43163 sol = new Prg_43163();
		String begin = "hit";
		String target = "cog";

		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

		System.out.println(sol.solution( begin, target, words));
	}
	static boolean[] visited;
	static int answer = Integer.MAX_VALUE;
	private static int solution(String begin, String target , String[] words ){
		/**
		 begin에서 한글자만 을 바꿔서 words에 있는 단어들을 거쳐
		 target이 되는 최소값을 리턴하라.
		 **/
		for( int i =0; i < words.length; i ++ ){

			visited = new boolean[words.length];
			if( isOneDiff( begin, words[i] ) ){
				visited[i] = true;
				search( words[i] , target , 1 , words );
			}

		}

		return answer == Integer.MAX_VALUE ? 0 : answer;
	}
	private static void search( String begin , String target, int count , String[] words ){

		if( begin.equals(target) ){

			answer = Math.min( answer , count );
			return;
		}

		if( count > words.length )
			return;

		for( int i = 0; i < words.length; i++ ){
			if( visited[i] )
				continue;

			if( isOneDiff( begin , words[i] )) {
				visited[i] = true;
				search( words[i] , target, count+1 , words );
				visited[i] = false;
			}
		}


	}
	private static boolean isOneDiff( String str1 , String str2 ){

		int count = 0;
		for( int i = 0; i < str1.length(); i++ ){
			if( str1.charAt(i) != str2.charAt(i) ){
				count++;
			}
		}

		if( count == 1 )
			return true;
		return false;
	}
}
