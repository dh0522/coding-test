package programmers;

public class Prg_77485 {
	public static void main(String[] args) {
		Prg_77485 sol = new Prg_77485();

		int[] result = sol.solution(6, 6, new int[][] {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}});
		for (int i : result)
			System.out.print(i + " ");
		System.out.println();



		int[] result1 = sol.solution(3, 3, new int[][] {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}});
		for (int i : result1)
			System.out.print(i + " ");
		System.out.println();
	}

	static int[][] arr;
	static int[][] temp;
	static int[] answer;
	public int[] solution(int rows, int columns, int[][] queries) {
		answer = new int[queries.length];

		arr = new int[rows][columns];
		int num = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++)
				arr[i][j] = num++;
		}

		temp = new int[arr.length][arr[0].length];

		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i].clone();
		}

		for (int i = 0; i < queries.length; i++) {

			int x1 = queries[i][0] - 1;
			int y1 = queries[i][1] - 1;
			int x2 = queries[i][2] - 1;
			int y2 = queries[i][3] - 1;


			turn(x1, y1, x2, y2 ,i);

		}

		return answer;
	}

	private static void turn(int x1, int y1, int x2, int y2, int idx) {

		int min = Integer.MAX_VALUE;


		first(temp,x1,x2,y1,y2);

		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {

				if (i != x1 && i != x2 && j != y1 && j != y2)
					continue;

				min = Math.min(min, arr[i][j]);

			}
		}
		answer[idx] = min;


	}
	private static void first( int[][] temp , int x1 ,int x2 , int y1 , int y2){

		int last = temp[x1][y2];

		for( int i = y2; i >= y1+1 ; i-- ){
			temp[x1][i] = temp[x1][i-1] ;

		}
		temp[x1][y1] = temp[x1+1][y1];

		for( int i = x2; i > x1+1; i -- ){
			temp[i][y2] = temp[i-1][y2];
		}
		temp[x1+1][y2] = last;


		for( int i = y1; i < y2; i++ ){
			temp[x2][i] = temp[x2][i+1];
		}
		temp[x2][y2-1] = arr[x2][y2];

		for( int i = x1; i < x2; i++ ){
			temp[i][y1] = temp[i+1][y1];
		}
		temp[x2-1][y1] = arr[x2][y1];


		for( int i =0; i < arr.length; i++ )
			arr[i] = temp[i].clone();
	}
}
