package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16235 {
	static int n,m,k;
	static int[][] food; // 양분
	static int[][] A; // 겨울 A배열
	static Queue<Tree> newTree = new LinkedList<>();
	static PriorityQueue<Tree> pq = new PriorityQueue<>(new Comparator<Tree>() {
		@Override
		public int compare( Tree o1 , Tree o2 ){
			return o1.age-o2.age;
		}
	});
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine() );

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		food = new int[n][n];
		A = new int[n][n];

		for( int i =0; i < n; i ++ ){
			st = new StringTokenizer(br.readLine());
			Arrays.fill( food[i] , 5 );
			for( int j=0; j < n; j++ ){
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for( int i =0; i < m; i++ ){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			Tree tree = new Tree(x,y,z);

			pq.add( tree );
		}

		while ( k-- > 0 ){

			firstHalf();
			fall();
			winter();
		}

		System.out.println( pq.size() );
	}

	private static void firstHalf(){

		Queue<Tree> die = new LinkedList<>();

		while( !pq.isEmpty() ){
			Tree now = pq.poll();

			if( food[now.x][now.y] - now.age < 0 ){
				die.add( now );
				continue;
			}
			food[now.x][now.y] -= now.age;
			now.age ++;
			newTree.add( now );
		}

		while( !die.isEmpty() ){
			Tree now = die.poll();
			food[now.x][now.y] += now.age/2 ;
		}

	}
	private static void fall(){

		while( !newTree.isEmpty() ){
			Tree now = newTree.poll();

			if( now.age % 5 == 0 ){
				for (int j = 0; j < 8; j++) {
					int nx = now.x + dx[j];
					int ny = now.y + dy[j];

					if (nx < 0 || ny < 0 || nx >= n || ny >= n)
						continue;

					pq.add(new Tree(nx, ny, 1));
				}
			}
			pq.add(now);
		}

	}
	private static void winter(){
		for( int i=0; i <n; i++ ){
			for( int j=0; j < n; j++ ){
				food[i][j] += A[i][j];
			}
		}
	}

	static class Tree {
		int x,y,age;

		public Tree( int x ,int y, int age ){
			this.x = x;
			this.y = y;
			this.age = age;
		}
	}
}


