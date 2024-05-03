package programmers;
import java.util.*;

public class Prg_12978 {
	public static void main(String[] args) {
		Prg_12978 sol = new Prg_12978();

		int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};

		System.out.println(sol.solution( 5, road , 3));
	}
	int[] distance;
	private int solution(int N , int[][] road , int K ) {
		int answer = 0;
		int[][] map = new int[N][N];

		for( int i = 0; i< N; i++ )
			Arrays.fill( map[i] , Integer.MAX_VALUE );

		for( int i = 0 ;i < N; i++ ){

			int a = road[i][0] - 1;
			int b = road[i][1] - 1;

			if( map[a][b] > road[i][2] ){
				map[a][b] = road[i][2];
				map[b][a] = road[i][2];
			}
		}
		map[0][0] = 0;

		int[] time = new int[N];
		Arrays.fill ( time , Integer.MAX_VALUE );

		PriorityQueue<Pair> q = new PriorityQueue<Pair>();

		q.offer( new Pair(0,0));
		time[0] = 0;

		while( !q.isEmpty() ){

			Pair now = q.poll();
			int point = now.end;
			int nowTime = now.time;

			for( int i = 0 ; i < N; i++ ){

				if( map[point][i] == Integer.MAX_VALUE )
					continue;

				int nextTime = map[i][point];
				if( time[i] > nowTime + nextTime ){
					time[i] = nowTime + nextTime;
					q.add( new Pair( i, time[i] ) );
				}

			}
		}

		for( int i = 0 ; i < N ; i ++ ){
			if( time[i] <= K )
				answer++;
		}

		return answer;

	}
	class Pair implements Comparable<Pair> {
		int end;
		int time;
		Pair( int end , int time ){
			this.end = end;
			this.time = time;
		}

		public int compareTo( Pair p ){
			return this.time - p.time > 0 ? 1 : -1;
		}
	}
}
