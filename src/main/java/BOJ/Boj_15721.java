package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_15721 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int t = Integer.parseInt(br.readLine());
		int want = Integer.parseInt(br.readLine()); // 뻔 = 0 , 데기 = 1

		int b = 0; // 뻔 개수
		int d = 0; // 데기 개수

		int count = 2;

		while( true ){

			for ( int i =0; i< 4; i++ ){
				if( i%2 == 0 ){
					b++;
					if( b== t && want == 0 ){
						System.out.println((b+d-1)%a);
						return;
					}
				}
				else{
					d++;
					if( d == t && want == 1 ){
						System.out.println((b+d-1)%a);
						return;
					}
				}
			}

			for (int i = 0; i < count; i++ ){
				b++;
				if( b== t && want == 0 ){
					System.out.println((b+d-1)%a);
					return;
				}
			}

			for (int i = 0; i < count; i++ ){
				d++;
				if( d == t && want == 1 ){
					System.out.println((b+d-1)%a);
					return;
				}
			}

			count++;

		}




	}
}
