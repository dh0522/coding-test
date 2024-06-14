package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj_5430 {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for( int i =0; i< t; i++ ){
			String order = br.readLine();
			int num = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(),"[],");

			Deque<Integer> list = new ArrayDeque<>();
			for( int k  =0 ; k < num; k++ )
				list.add(Integer.parseInt(st.nextToken()));
			func(order , num , list);

		}
		System.out.println(sb);

	}

	public static void func(String order, int num , Deque<Integer> list ){

		boolean reverse = false;

		for( int i = 0 ; i < order.length(); i ++ ){

			char now = order.charAt(i);
			if( now == 'R' )
				reverse = !reverse;
			else if( now == 'D' ) {
				if (list.isEmpty()) {
					sb.append("error\n");
					return;
				} else if (reverse) {
					list.pollLast();
				} else if (!reverse)
					list.pollFirst();
			}

		}
		print( list , reverse );
	}
	public static void print( Deque<Integer> dq , boolean reverse ){


		if( dq.isEmpty() ) {
			sb.append("[]\n");
			return;
		}

		sb.append("[");
		if( reverse ){

			sb.append( dq.pollLast());
			while( !dq.isEmpty() ){
				sb.append(",").append(dq.pollLast());
			}

		}else{

			sb.append(dq.pollFirst());
			while(!dq.isEmpty() ){
				sb.append(",").append(dq.pollFirst());
			}
		}
		sb.append("]\n");
		return;
	}
}
