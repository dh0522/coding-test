package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14888 {
	static int[] arr;
	static int n;
	static int[] operator;
	// 0 : + , 1 : - , 2 = * , 3 = /
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for( int i = 0 ;i < n ; i ++ ){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		operator= new int[4];

		st = new StringTokenizer(br.readLine());
		for( int i =0 ; i <4; i ++ ){
			operator[i] = Integer.parseInt(st.nextToken());
		}

		dfs(arr[0] ,1 );
		System.out.println(max+"\n"+min);

	}

	private static void dfs( int num ,  int count ){

		if( count == n ){
			max = Math.max( max , num );
			min = Math.min( min ,num );
			return;
		}

		for( int i = 0 ; i < 4; i++ ){

			if(operator[i] == 0 )
				continue;
			operator[i]--;
			switch(i){
				case 0:
					dfs(num + arr[count],  count + 1);
					break;
				case 1:
					dfs( num - arr[count] , count+1 );
					break;
				case 2:
					dfs(num * arr[count],  count + 1);
					break;
				case 3:
					dfs( num / arr[count] , count+1 );
					break;
			}
			operator[i]++;
		}


	}
}
