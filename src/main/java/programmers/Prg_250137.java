package programmers;

public class Prg_250137 {
	public static void main(String[] args) {
		Prg_250137 sol = new Prg_250137();

		System.out.println(sol.solution( new int[]{5,1,5}, 30, new int[][]{{2,10},{9,15},{10,5},{11,5}}));
	}

	private int solution(int[] bandage, int health , int[][] attacks ) {
		int diff = 0;
		int attIdx = 0;
		int nowTime = 0;
		int nowHealth = health;
		boolean check = false;


		while( nowHealth > 0 && attIdx < attacks.length ){
			diff = attacks[attIdx][0] - 1 - nowTime ;
			nowTime = attacks[attIdx][0] - 1;

			if( diff > 0 )
				nowHealth += bandage[2]*( diff/bandage[0] ) + bandage[1]*diff;

			if( nowHealth > health )
				nowHealth = health;

			nowTime ++ ;
			nowHealth -= attacks[attIdx][1];

			if( nowHealth <= 0 )
				check = true;
			attIdx++;

		}

		return check == true ? -1 : nowHealth;

	}
}
