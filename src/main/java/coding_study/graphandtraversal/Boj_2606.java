package coding_study.graphandtraversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_2606 {
	static int answer = 0;
	static boolean[] visited;
	static List<List<Integer>> graph = new ArrayList<>();
	public static void main(String[] args) throws Exception {

		int one = 0;
		int two = 0;
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int computer = Integer.parseInt(br.readLine());
		int connect = Integer.parseInt(br.readLine());

		visited = new boolean[computer+1];
		for (int i = 0; i <= computer; i++ ){
			graph.add( new ArrayList<>() );
		}

		for (int i =0; i < connect; i++ ) {
			st = new StringTokenizer(br.readLine());

			one = Integer.parseInt(st.nextToken());
			two = Integer.parseInt(st.nextToken());

			graph.get(one).add(two);
			graph.get(two).add(one);
		}


		dfs( 1  );

		System.out.println( answer == 0 ? 0 : answer -1 );
	}
	private static void dfs(int now){

		for ( int i = 0; i < graph.get(now).size(); i++ ){
			int next = graph.get(now).get(i);
			if ( visited[next] )
				continue;
			answer++;
			visited[next] = true;
			dfs(next);
		}
	}

}
