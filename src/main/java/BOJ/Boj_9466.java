package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_9466 {
	static boolean[] done;
	static boolean[] visited;
	static int[] arr;
	static int people;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		while( t-- > 0 ){

			int n = Integer.parseInt(br.readLine());
			people = 0;

			arr = new int[n+1];
			done = new boolean[n+1];
			visited = new boolean[n+1];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for( int i = 1; i <= n; i++ ){
				arr[i] = Integer.parseInt(st.nextToken());
				if( arr[i] == i ) {
					done[i] = true;
					people++;
				}
			}

			for( int i = 1; i <= n; i++ ){
				if( done[i] )
					continue;
				teamProject(i );
			}
			sb.append(n-people+"\n");
		}

		System.out.print(sb);
	}
	private static void teamProject( int first ){
		if( done[first] )
			return;
		// !done

		if( visited[first] ){
			// cycle 이라는 것
			done[first] = true;
			people++;
		}
		visited[first] = true;
		teamProject(arr[first]);

		done[first] = true;
		visited[first] = false;
	}
}
