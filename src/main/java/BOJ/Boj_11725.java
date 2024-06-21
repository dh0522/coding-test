package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class Boj_11725 {
	static int n ;
	static boolean[] visited;
	static int[] mom;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		for( int i = 0 ;i <= n; i++ )
			list.add(new ArrayList<>());

		mom = new int[n+1];
		visited = new boolean[n+1];

		StringTokenizer st;
		for( int i = 0 ;i < n-1; i ++ ){
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list.get(a).add(b);
			list.get(b).add(a);

		}


		bfs(1);

		StringBuilder sb = new StringBuilder();
		for( int i=2;i<=n;i++  ){
			sb.append(mom[i]+"\n");
		}
		System.out.println(sb);
	}
	public static void bfs(int now){

		Queue<Integer> q = new LinkedList<>();
		q.add(now);

		visited[now] = true;

		while(!q.isEmpty()){
			int nowNode = q.poll();

			for( int i = 0 ; i < list.get(nowNode).size() ; i++ ){

				int nextNode = list.get(nowNode).get(i);
				if( !visited[nextNode] ){
					visited[nextNode] = true;
					mom[nextNode] = nowNode;
					q.add(nextNode);
				}
			}
		}
	}
}
