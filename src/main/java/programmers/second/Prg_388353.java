package programmers.second;

import java.util.LinkedList;
import java.util.Queue;

public class Prg_388353 {
	public static void main(String[] args) {
		Prg_388353 sol = new Prg_388353();

		System.out.println(sol.solution(new String[]{"AZWQY", "CAABX", "BBDDA", "ACACA"}, new String[]{"A", "BB", "A"}));

	}
	static int n,m;
	static boolean[][] edge;
	private static int solution(String[] storage, String[] requests) {
		n = storage.length;
		m = storage[0].length();
		edge = new boolean[n][m];

		int answer = n*m;

		char[][] chArr= new char[n][m];
		for(int i=0; i < n; i++){
			chArr[i] = storage[i].toCharArray();
		}


		char[][] tmp = new char[n][m];

		for(int i=0; i < requests.length; i++){
			char ch = requests[i].charAt(0);


			for(int j=0; j < n; j++){
				tmp[j] = chArr[j].clone();
			}


			if(requests[i].length() == 2){

				for(int k=0; k < n; k++){
					for(int j=0; j<m; j++){
						if(chArr[k][j] == ch) {
							tmp[k][j] = '0';
							answer--;
						}
					}
				}

			}else{

				for(int k=0; k < n; k++){
					for(int j=0; j<m; j++){
						if(chArr[k][j] == ch && bfs(chArr, ch, k, j) ) {
							tmp[k][j] = '0';
							answer--;
						}
					}
				}
			}

			for(int j=0; j < n; j++){
				chArr[j] = tmp[j].clone();
			}

		}


		return answer;
	}

	private static boolean bfs(char[][] chArr, char ch, int x, int y){
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];

		q.add(new int[]{x,y});
		visited[x][y] = true;

		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};


		while(!q.isEmpty()){
			int[] now = q.poll();
			x = now[0];
			y = now[1];

			for(int d = 0;  d < 4; d++){
				int nx = x + dx[d];
				int ny = y + dy[d];

				if( nx < 0 || ny < 0 || nx > n-1 || ny > m-1 ){
					return true;
				}


				if(chArr[nx][ny] == '0' && !visited[nx][ny]){
					visited[nx][ny] = true;
					q.add(new int[]{nx,ny});
				}

			}
		}



		return false;
	}
}
