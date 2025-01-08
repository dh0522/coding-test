package coding_study.tree;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_11725 {
	public static void main(String[] args) throws Exception {

		int a, b;
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		List<List<Integer>> list = new ArrayList<>();
		// 둘째 줄 부터 N-1 개의 줄에 트리상에서 연결된 두 정점이 주어진다.
		for( int i = 0; i <= n ; i++ )
			list.add( new ArrayList<>() );

		for( int i = 0; i < n-1; i++ ){
			st = new StringTokenizer( br.readLine() );

			a = Integer.parseInt( st.nextToken() );
			b = Integer.parseInt( st.nextToken() );

			list.get(a).add(b);
			list.get(b).add(a);
		}



		int[] mom = new int[n+1];
		int momIdx = 0;
		int sonIdx = 0;

		Queue<Integer> q = new ArrayDeque<>();
		q.add( 1 );

		while( !q.isEmpty() ){

			momIdx = q.poll();

			for( int i = 0; i < list.get(momIdx).size(); i ++ ){
				sonIdx = list.get(momIdx).get(i);
				if( mom[sonIdx] != 0 )
					continue;
				mom[sonIdx] = momIdx;
				q.add( sonIdx );
			}

		}


		StringBuilder sb = new StringBuilder();
		for( int i =2; i <= n; i++ ){
			sb.append(mom[i]).append("\n");
		}
		System.out.println( sb );

	}
}
