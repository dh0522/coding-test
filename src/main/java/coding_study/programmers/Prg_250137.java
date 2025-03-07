package coding_study.programmers;

public class Prg_250137 {
	public static void main(String[] args) {
		Prg_250137 sol = new Prg_250137();

		System.out.println(sol.solution(new int[]{5, 1, 5}, 30, new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5 }} ) );

	}
	private int solution(int[] bandage, int health, int[][] attacks) {

		int nowTime = 0;
		int nowHealth = health;

		for(int[] attack : attacks){

			int recoveryTime = attack[0] - nowTime - 1; // 회복할 수 있는 시간

			int recovery = (recoveryTime/bandage[0])*(bandage[0]*bandage[1] + bandage[2])
				+ (recoveryTime%bandage[0]) * bandage[1];


			nowHealth = (nowHealth + recovery) >= health ? health : nowHealth + recovery;

			// 공격 받기
			nowTime = attack[0];
			nowHealth -= attack[1];

			if( nowHealth <= 0 ){
				return -1;
			}


		}

		return nowHealth;
	}
}
