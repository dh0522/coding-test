package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17825 {
	static int answer = Integer.MIN_VALUE;
	static int [] map = {
		0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 0, //0 ~ 21
		10, 13, 16, 19, 25, 30, 35, 40, 0,  //22 ~ 30
		20, 22, 24, 25, 30, 35, 40, 0,      //31 ~ 38
		30, 28, 27, 26, 25, 30, 35, 40, 0};
	static int[] dice = new int[10];
	static int[] horse = new int[10];
	public static void main(String[] args) throws Exception {
		//https://koguri.tistory.com/56
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		for( int i =0; i < 10; i++ ){
			dice[i] = Integer.parseInt(st.nextToken());
		}

		Horse[] horse = new Horse[4];
		for( int i=0; i < 4; i++ ){
			horse[i] = new Horse( 0 , false , 0 );
		}

		permutation( 0 );

		System.out.println( answer );

	}
	private static void permutation( int depth ){
		if( depth == 10 ){
			playGame();
			return;
		}

		for( int i=0; i < 4; i ++ ){
			horse[depth] = i;
			permutation( depth + 1 );
		}
	}
	private static void playGame(){

		boolean[] visited = new boolean[map.length];
		int score = 0;
		int[] place = new int[4];

		for( int i=0; i < 10; i ++ ){
			int nowDice = dice[i];
			int nowHorse = horse[i];

			if( isFinish( place[nowHorse] ))
				return;

			int next = nextPoint( place[nowHorse], nowDice );


		}


	}

	private static int nextPoint( int nowIdx , int dice  ){

		int nextIdx = nowIdx + dice;
		// red
		if( nowIdx < 21 ) {
			if( nextIdx >= 21 )
				nextIdx = 21;
		}else if ( nowIdx < 30 ){
			if( nextIdx >= 30 )
				nextIdx = 30;
		}else if( nowIdx < 38 ){

		}

	}
	private static boolean isFinish( int idx ){
		return idx == 21 || idx == 30 || idx == 38 || idx == 47;
	}
	static class Horse{
		int score;
		boolean finish;
		int colorRoot;

		Horse( int score , boolean finish , int colorRoot ){
			this.score = score;
			this.finish = finish;
			this.colorRoot = colorRoot;
		}
	}
}
