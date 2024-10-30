package programmers.second;

public class Prg_43162 {
	public static void main(String[] args) {
		Prg_43162 sol = new Prg_43162();

		int[][] computers = {{ 1, 1, 0}, {1, 1, 0}, {0, 0, 1 }};

		System.out.println(sol.solution(3, computers));
	}
	static boolean[] visited;
	private static int solution( int n , int[][] computers ){
		int answer = 0;
		visited = new boolean[n];

		for( int i =0; i < n ; i++ ){
			if( visited[i] )
				continue;

			dfs( i , computers );
			answer++;
		}

		return answer;
	}
	private static void dfs( int now , int[][] computers ){



		visited[now] = true;
		for( int i=0; i < computers.length ; i++ ){
			if( visited[i] )
				continue;
			if( computers[now][i] == 0 )
				continue;

			dfs( i , computers );
		}

	}
}
