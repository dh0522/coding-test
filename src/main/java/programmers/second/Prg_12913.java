package programmers.second;

public class Prg_12913 {
	public static void main(String[] args) {
		Prg_12913 sol = new Prg_12913();

		System.out.println(sol.solution( new int[][]{{ 1,2,3,5},{5,6,7,8},{4,3,2,1 }}));
	}

	private static int solution( int[][] land ){


		int answer = 0;
		for( int i =1; i < land.length; i++ ){

			for( int j =0; j < 4; j++ ){

				int max = 0;
				for( int k = 0; k < 4; k++ ){
					if( j== k )
						continue;
					max = Math.max( max , land[i-1][k] );
				}
				land[i][j] += max;
				answer = Math.max( answer , land[i][j] );
			}


		}
		return answer;
	}
}
