package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Prg_42579 {
	public static void main(String[] args) {
		Prg_42579 sol = new Prg_42579();
		System.out.println(
			Arrays.toString(sol.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})));
	}
	private static int[] solution(String[] genres, int[] plays) {

		// hm -> genres 총 음악재생 수
		HashMap<String, Integer> hm = new HashMap<>();

		// 각 장르별 최대,그 다음 ...
		HashMap<String, List<Song>> playList = new HashMap<>();

		for(int i = 0; i < genres.length; i++){
			hm.put(genres[i], hm.getOrDefault(genres[i], 0) + plays[i]);

			if(playList.containsKey(genres[i])){
				playList.get(genres[i]).add(new Song(i, plays[i]));
			}else{
				List<Song> list = new ArrayList<>();
				list.add(new Song(i, plays[i]) );
				playList.put(genres[i], list);
			}
		}

		List<Map.Entry<String, Integer>> entryList = new LinkedList<>(hm.entrySet());
		entryList.sort(new Comparator<>(){
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
				return o2.getValue() - o1.getValue();
			}
		});

		List<Integer> ans = new ArrayList<>();
		for(Map.Entry<String, Integer> entry: entryList ){
			String key = entry.getKey();
			List<Song> list = playList.get(key);

			if(list.size() == 1){
				ans.add(list.get(0).idx);
				continue;
			}

			Collections.sort(list);
			ans.add(list.get(0).idx);
			ans.add(list.get(1).idx);

		}

		return ans.stream().mapToInt(Integer::intValue).toArray();
	}
}
class Song implements Comparable<Song>{
	int idx;
	int play;
	public Song(int idx, int play){
		this.idx = idx;
		this.play = play;
	}

	@Override
	public int compareTo(Song o1){
		if(o1.play == this.play)
			return this.idx - o1.idx;
		return o1.play - this.play;
	}
}
