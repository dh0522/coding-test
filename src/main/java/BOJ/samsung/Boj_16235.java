package BOJ.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16235 {
	static int n, m, k;
	static PriorityQueue<Tree> treeList = new PriorityQueue<>();
	static PriorityQueue<Tree> pq = new PriorityQueue<>();
	static Queue<Tree> dead = new LinkedList<>();
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		// 양분
		int[][] land = new int[n][n];


		// 겨울이 자나면 넣어줄 양분 배열
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++){
			Arrays.fill(land[i], 5);
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++){
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < m; i++){
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken()) ;

			Tree tree = new Tree(x,y,age);
			treeList.add(tree);
		}

		while(k-- > 0){
			spring(land);
			summer(land);
			fall();
			winter(land, a);
		}


		System.out.println(treeList.size());

	}
	private static void spring(int[][] land){

		while(!treeList.isEmpty()){
			Tree tree = treeList.poll();

			int age = tree.age;

			if (land[tree.x][tree.y] >= age){
				land[tree.x][tree.y] -= age;
				pq.add(new Tree(tree.x, tree.y, age+1));
			}else{
				dead.add(tree);
			}
		}


	}
	private static void summer(int[][] land){
		// 2. 여름 = 봄에 죽은 나무가 양분으로 변한다.
		//		 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무에 있던 칸에 양분으로 추가된다.
		while(!dead.isEmpty()){
			Tree tree = dead.poll();
			land[tree.x][tree.y] += (tree.age/2);
		}

	}

	private static void fall(){
		// 3. 가을 = 나무가 번식한다.
		// 		 번식하는 나무는 나이가 5의 배수여야 하며,
		//		 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
		while(!pq.isEmpty()){

			Tree tree = pq.poll();
			treeList.add(tree);

			if (tree.age % 5 == 0){
				int x = tree.x;
				int y = tree.y;

				for (int d = 0; d < 8; d++ ){
					int nx = x + dx[d];
					int ny = y + dy[d];

					if (nx < 0 || ny <0 || nx >= n || ny >= n)
						continue;

					Tree newTree = new Tree(nx,ny,1);
					treeList.add(newTree);
				}
			}

		}


	}

	private static void winter(int[][] land, int[][] a){
		// 4. 겨울 = 땅을 돌아다니며, 땅에 양분을 추가한다.
		//	   	  각 칸에 추가되는 양분의 양은 A[r][c]
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				land[i][j] += a[i][j];
			}
		}
	}
}
class Tree implements Comparable<Tree> {
	int x;
	int y;
	int age;

	public Tree(int x , int y , int age){
		this.x = x;
		this.y = y;
		this.age = age;
	}

	@Override
	public int compareTo(Tree o1){
		return this.age - o1.age;
	}
}
