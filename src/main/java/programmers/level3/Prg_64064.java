package programmers.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Prg_64064 {
	public static void main(String[] args) {
		Prg_64064 sol = new Prg_64064();
		System.out.println(sol.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"} , new String[] {"fr*d*", "abc1**"}));
		System.out.println(sol.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"} , new String[] {"*rodo", "*rodo", "******"}));
		System.out.println(sol.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"} , new String[] {"fr*d*", "*rodo", "******", "******"}));
	}
	static Map<String, List<String>> hm;
	static Set<String> set;
	private int solution(String[] user_id, String[] banned_id) {
		hm = new HashMap<>();
		set = new HashSet<>();
		for(int i = 0; i < banned_id.length; i++){

			String banName = banned_id[i];
			hm.put(banName, new ArrayList<>());

			for(int j = 0; j < user_id.length; j++){
				String nowName = user_id[j];
				boolean check = true;

				if(nowName.length() != banName.length()){
					continue;
				}

				for(int k = 0; k < nowName.length(); k++){
					if(banName.charAt(k) == '*')
						continue;

					if(banName.charAt(k) != nowName.charAt(k)){
						check = false;
						break;
					}
				}

				if(check)
					hm.get(banName).add(nowName);
			}
		}



		for(int i = 0; i < hm.get(banned_id[0]).size(); i++ ){
			List<String> keyList = new ArrayList<>();

			keyList.add(hm.get(banned_id[0]).get(i));
			dfs(keyList, 1, banned_id);
		}


		return set.size();
	}
	private static void dfs(List<String> keyList, int idx, String[] banned_id){
		if(idx == banned_id.length){
			String now = "";
			Collections.sort(keyList);
			for(int i = 0; i < keyList.size(); i++){
				now += keyList.get(i);
			}
			set.add(now);
			return;
		}

		for(int i = 0; i < hm.get(banned_id[idx]).size(); i++){
			if(keyList.contains( hm.get(banned_id[idx]).get(i)) )
				continue;

			keyList.add(hm.get(banned_id[idx]).get(i));
			dfs(keyList, idx+1, banned_id);
			keyList.remove(hm.get(banned_id[idx]).get(i));
		}
	}

}
