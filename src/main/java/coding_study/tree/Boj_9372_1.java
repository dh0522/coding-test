package coding_study.tree;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_9372_1 {
	public static void main( String[] args ) throws Exception {


		int nara1 = 0;
		int nara2 = 0;
		int nationNum = 0;
		int flightKind = 0;
		boolean[][] check;
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int t = Integer.parseInt( br.readLine() );


		while( t-- > 0 ){


			st = new StringTokenizer( br.readLine() );
			nationNum = Integer.parseInt( st.nextToken() );
			flightKind = Integer.parseInt( st.nextToken() );

			check = new boolean[nationNum+1][nationNum+1] ;

			for( int i = 0; i < flightKind; i++ ){
				st = new StringTokenizer( br.readLine() );

				nara1 = Integer.parseInt( st.nextToken() );
				nara2 = Integer.parseInt( st.nextToken() );

				check[nara1][nara2] = true;
				check[nara2][nara1] = true;
			}


			sb.append( getMin(1,check) );
			sb.append("\n");
		}

		System.out.println( sb );
	}
	private static int getMin( int now, boolean[][] check ){

		Queue<Integer> q = new ArrayDeque<>();
		int count = 0;
		int[] visited = new int[check.length+1];
		q.add( now );

		while( !q.isEmpty() ){
			now = q.poll();

			for( int i = 0; i < check[0].length; i ++ ){
				if( !check[now][i] )
					continue;

				if( visited[i] != 0 )
					continue;

				visited[i] = visited[now] + 1;
				q.add( i );
				count++;
			}
		}

		return count-1;
	}
}
