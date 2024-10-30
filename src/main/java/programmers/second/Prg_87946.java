package programmers.second;

public class Prg_87946 {
	public static void main(String[] args) {

		Prg_87946 sol = new Prg_87946();
		System.out.println(sol.solution( 80 , new int[][]{{80,20},{50,40},{30,10}}));
	}
	static boolean[] visited;
	static int answer = Integer.MIN_VALUE;
	private static int solution ( int k , int[][] dungeons ){
		visited = new boolean[dungeons.length];
		dfs( 0 , k, dungeons );

		return answer;
	}
	private static void dfs( int count , int power ,int[][] dungeons ){
		if( power < 0 )
			return;
		answer = Math.max( answer , count );

		for( int i=0; i < dungeons.length; i++ ){
			if( visited[i] )
				continue;
			if( power < dungeons[i][0] )
				continue;

			visited[i] = true;
			dfs(  count+1 , power-dungeons[i][1] ,dungeons );
			visited[i] = false;
		}
	}
}
