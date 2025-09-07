package programmers.level3;

public class Prg_12979 {
	public static void main(String[] args) {
		Prg_12979 sol = new Prg_12979();
		System.out.println(sol.solution(11, new int[]{4, 11}, 1));
	}
	private int solution(int n, int[] stations, int w) {

		int answer = 0;
		int possibleWave = 1 + 2*w;

		int ex = 0;

		for(int i = 0; i < stations.length; i++){

			int num = stations[i];
			/// 기지국 영향받는 첫번째 아파트 - 받지 못하는 첫번째 아파트  = 전파 못받는 아파트 개수
			int diff = (num - w) - ex - 1;
			if(diff < 0)
				diff = 0;

			answer += (diff % possibleWave == 0) ? diff / possibleWave : diff / possibleWave + 1;
			ex = num + w;
		}


		if(ex < n){
			int res = n - ex ;

			answer += res % possibleWave == 0 ?  res / possibleWave
				: res / possibleWave + 1;
		}



		return answer;
	}
}
