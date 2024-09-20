package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Boj_2885 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int k = Integer.parseInt(br.readLine());

		int size = 1;

		while(true){
			if (size < k ){
				size *= 2;
			}else break;
		}

		sb.append(size+" ");

		int count = 0;
		while( k != 0 ){

			if( k >= size ){
				k-= size;
			}else{
				size /=2 ;
				count++;
			}
		}
		sb.append(count);
		System.out.println(sb);
	}
}
