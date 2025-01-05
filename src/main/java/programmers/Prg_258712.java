package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prg_258712 {
	public static void main(String[] args) {
		Prg_258712 sol = new Prg_258712();

		String[] friends = {"muzi", "ryan", "frodo", "neo"};
		String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

		System.out.println(sol.solution( friends, gifts ));
	}
	private static int[][] record;
	private int solution(String[] friends, String[] gifts) {

		int[] gift = new int[friends.length];
		record = new int[friends.length][friends.length];
		List<String> friend = new ArrayList<>( Arrays.asList(friends) );

		for( String str : gifts ){
			String give = str.split(" ")[0];
			String receive = str.split(" ")[1];

			record[ friend.indexOf(give) ][ friend.indexOf( receive )]++;
		}

		for( int i = 0; i < record.length; i++ ){
			for( int j =i+1 ; j < record.length; j++ ){

				if( record[i][j] > record[j][i] )
					gift[i]++;
				else if( record[i][j] < record[j][i] )
					gift[j]++;
				else{

					int giftIndex1 = getIndex(i);
					int giftIndex2 = getIndex(j);

					if( giftIndex1 > giftIndex2 )
						gift[i]++;
					else if( giftIndex1 < giftIndex2 )
						gift[j]++;

				}
			}
		}

		Arrays.sort( gift );

		return gift[gift.length-1];
	}

	private static int getIndex( int people ){
		int giveSum = 0;
		int receiveSum = 0;

		for( int i = 0;i < record.length; i++ )
			giveSum += record[people][i];

		for( int j =0; j < record.length; j++ )
			receiveSum += record[j][people];

		return giveSum-receiveSum;
	}
}
