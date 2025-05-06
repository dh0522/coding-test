package programmers.second;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Prg_42890 {
	public static void main(String[] args) {
		Prg_42890 sol = new Prg_42890();

		System.out.println(sol.solution(new String[][] {{ "100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}}));
	}
	static List<String> keys = new ArrayList<>();
	private static int solution(String[][] relation){

		// 1. 모든 조합 가져오기
		getKeys( 0, "" , relation);
		Collections.sort(keys, new Comparator<>(){
			@Override
			public int compare(String k1, String k2){
				return k1.length()- k2.length();
			}
		});

		// 2. 키 돌면서 가능한지 확인하기
		List<String> candidateKey = new ArrayList<>();

		for(int i=0; i< keys.size(); i++){
			if(!isKey(keys.get(i), relation))
				continue;

			boolean check = true;
			for(String key: candidateKey){

				if(removeKey(key, keys.get(i))){
					check = false;
					break;
				}
			}


			if( check )
				candidateKey.add(keys.get(i));

		}

		return candidateKey.size();
	}


	private static boolean removeKey(String realKey, String key){
		for(char ch: realKey.toCharArray() ){
			if(!key.contains(String.valueOf(ch))){
				return false;
			}
		}

		return true;
	}


	private static boolean isKey(String key, String[][] relation){

		Set<String> temp = new HashSet<>();
		for(int i=0; i < relation.length; i++){
			StringBuilder tmp = new StringBuilder() ;

			for(int j=0; j< key.length(); j++){
				int num = Integer.parseInt( key.charAt(j) +"" );
				tmp.append(relation[i][num]);
			}

			temp.add(tmp.toString());
		}
		return temp.size() == relation.length ? true : false ;
	}

	private static void getKeys(int depth, String key, String[][] relation){

		if( depth == relation[0].length+1 ){
			return;
		}

		for(int i = depth; i< relation[0].length; i++){

			keys.add( key + i );
			getKeys( i+1, key + String.valueOf(i) , relation );

		}
	}
}
