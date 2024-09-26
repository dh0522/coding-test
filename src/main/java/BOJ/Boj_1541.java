package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_1541 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
		String full = br.readLine();

		String[] first = full.split("-");
		Queue<Integer> q = new LinkedList<>();
		for ( int i =0; i< first.length; i++ ){
			String[] second = first[i].split("\\+");

			int sum = 0;
			for (int j =0; j < second.length; j++ ){
				sum += Integer.parseInt( second[j] );
			}
			q.add( sum );
		}

		int answer = q.poll();
		while ( q.size()!= 0 ){
			answer -= q.poll();
		}

		System.out.println( answer );
	}
}
