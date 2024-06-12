package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1193 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int x = Integer.parseInt(br.readLine());


		int sum = 0; // 분모 + 분자
		int line = 1;

		while( sum < x ){

			sum += line;
			line++;
		}
		line -= 1;

		int n = x - sum(line); // 줄에서 몇번째인지
		int allSum = line+1;

		int mom = 0;
		int son = 0;

		if( line % 2 == 0 ){

			mom = allSum - n;
			son = n;


		}else{
			mom = n;
			son = allSum - n;

		}

		System.out.println(son+"/"+mom);

	}
	public static int sum( int  line ){

		int n = 0;
		for(int i = 0;i < line; i++ ){
			n += i;
		}
		return n;
	}
}
