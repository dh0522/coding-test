package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_11047 {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		// 가치의 합을 k로 만들려고 한다. 이때 필요한 동전 개수의 최소값을 구하여라
		Stack<Integer> list = new Stack<>();

		for (int i=0; i <n; i++ ){
			int coin = Integer.parseInt(br.readLine());
			if( coin <= k )
				list.add(coin);
		}

		if ( list.contains(k) ) {
			System.out.println(1);
			return;
		}

		int answer = 0;
		while( k != 0 ){
			int now = list.pop();

			answer += k/now;
			k = k%now;
		}
		System.out.println(answer);

	}
}
