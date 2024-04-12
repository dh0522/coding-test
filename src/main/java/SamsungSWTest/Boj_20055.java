package SamsungSWTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_20055 {
	static int[] A;
	static boolean[] visited ;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine() );

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		A = new int[n*2];
		visited = new boolean[n*2];
		st = new StringTokenizer(br.readLine());

		for( int i =0 ;i < A.length; i++ ){
			A[i] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;

		while(true) {

			answer++;
			beltRotation(2 * n);

			// 2번
			for (int i = n - 2; i >= 0; i--) {
				if ( !visited[i + 1] && visited[i] && A[i + 1] > 0) {
					visited[i + 1] = true;
					visited[i] = false;
					A[i + 1]--;
				}
			}

			// 3번
			if (A[0] > 0) {
				visited[0] = true;
				A[0]--;
			}

			if(isNumber(k))
				break;
		}

		System.out.println( answer );
	}
	public static void beltRotation(int n){

		int temp = A[n-1];
		for( int i = n-2; i >= 0 ; i-- ){
			A[i+1] = A[i];
		}
		A[0] = temp;

		boolean tmp = visited[n-1];
		for( int i = n-2; i>= 0; i-- ){
			visited[i+1] = visited[i];
		}
		visited[0] = false;
		visited[n/2 -1 ] = false;

	}

	public static boolean isNumber( int k ){

		int num = 0;
		for( int i = 0; i < A.length ;i++ ){
			if( A[i] == 0 )
				num++;
		}

		if( num >= k )
			return true;
		return false;
	}

}
