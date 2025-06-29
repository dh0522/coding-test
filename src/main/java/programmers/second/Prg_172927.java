package programmers.second;

public class Prg_172927 {
	public static void main(String[] args) {
		Prg_172927 sol = new Prg_172927();

		System.out.println(sol.solution(new int[]{1,3,2}, new String[]{ "diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone" }));
		answer = Integer.MAX_VALUE;
		System.out.println(sol.solution(new int[]{0, 1, 1}, new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"}));
	}
	private static int answer = Integer.MAX_VALUE;
	private int solution(int[] picks, String[] minerals) {

		for(int i=0; i < 3; i++){
			if(picks[i] == 0)
				continue;

			int[] tmpPicks = picks.clone();
			int power = 0;

			tmpPicks[i]--;

			for(int j = 0; j < minerals.length && j < 5; j++){
				power += dig(minerals[j], i);
			}

			dfs(5, power, tmpPicks, minerals);

		}
		return answer;
	}
	private static void dfs(int index, int power, int[] picks, String[] minerals){
		if( index >= minerals.length || isAllZero(picks) ){
			answer = Math.min(answer, power);
			return;
		}


		for(int i = 0; i < 3; i++){
			if(picks[i] == 0)
				continue;

			int tmpPower = power;

			for(int j = index; j < minerals.length && j < index + 5; j++){
				tmpPower += dig(minerals[j], i);
			}
			picks[i]--;
			dfs(index + 5, tmpPower, picks, minerals);
			picks[i]++;
		}
	}
	private static boolean isAllZero(int[] picks){
		for(int i :picks){
			if( i != 0 )
				return false;
		}
		return true;
	}
	private static int dig(String mineral, int pick){

		switch(pick){
			case 0:
				return 1;
			case 1:
				if(mineral.equals("diamond"))
					return 5;
				else
					return 1;
			case 2:
				if(mineral.equals("diamond"))
					return 25;
				else if(mineral.equals("iron"))
					return 5;
				else
					return 1;
		}
		return 0;
	}


}
