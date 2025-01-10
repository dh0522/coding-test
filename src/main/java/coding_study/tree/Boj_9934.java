package coding_study.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_9934 {
	public static void main(String[] args) throws Exception{

		int k = 0; // 깊이
		StringTokenizer st ;
		List<Integer> list = new ArrayList<>();
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());

		// 이미 완전 이진트리라는 조건이 있음
		// 그렇다면 노드의 개수 = 2^k -1

		List<List<Integer>> tree = new ArrayList<>();
		for( int i = 0 ; i <= k; i++ )
			tree.add( new ArrayList<>() );


		st = new StringTokenizer(br.readLine());
		for( int i =0; i < (int)Math.pow(2,k) - 1; i ++ ){
			if ( i%2 == 0 ) {
				tree.get(k).add(Integer.parseInt(st.nextToken()));
			}else {
				list.add(Integer.parseInt(st.nextToken()));
			}
		}

		List<Integer> tmpList = new ArrayList<>(List.copyOf(list));
		while( !list.isEmpty() ){
			k--;
			for( int i = 0; i < list.size(); i++ ){
				if( i%2 == 0 ){
					tree.get(k).add( list.get(i) );
					tmpList.remove( tmpList.indexOf( list.get(i) ));
				}
			}
			list = List.copyOf( tmpList );
		}

		StringBuilder sb = new StringBuilder();
		for ( int i =1; i < tree.size(); i++){
			for ( int j = 0; j < tree.get(i).size(); j ++ ){
				sb.append(tree.get(i).get(j)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
