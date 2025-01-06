package programmers.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Prg_92341 {
	public static void main(String[] args) {

		Prg_92341 sol = new Prg_92341();
		
		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };

		System.out.println( Arrays.toString( sol.solution( fees, records )));
	}
	public int[] solution(int[] fees, String[] records) {

		String car = "";
		List<String> list = new ArrayList<>();
		HashMap<String, Integer> hm = new HashMap<>();

		for( String str : records ){

			car = str.split(" ")[1];
			if( list.contains( car ) )
				continue;
			list.add( car );
			hm.put( car , 0 );
		}

		Collections.sort( list );

		int[] inTime = new int[list.size()];
		Arrays.fill( inTime , -1 );

		for( String record : records ){
			String[] arr = record.split(" ");
			String[] timeStr = arr[0].split(":");

			int time = Integer.parseInt(timeStr[0])*60 + Integer.parseInt(timeStr[1]);
			if( arr[2].equals("IN") ){
				inTime[ list.indexOf(arr[1])] = time;

			}else if( arr[2].equals("OUT") ){
				time -= inTime[ list.indexOf(arr[1]) ];
				hm.put( arr[1] , hm.get( arr[1] ) + time );
				inTime[ list.indexOf(arr[1]) ] = -1;
			}
		}


		for( int i = 0; i < inTime.length; i++ ){
			if( inTime[i] == -1 )
				continue;
			hm.put( list.get(i), hm.get(list.get(i)) + (23*60+59 - inTime[i]) );
		}

		int sumFee = 0;
		int fullTime = 0;

		List<Integer> answer = new ArrayList<>();

		for( String key : list ){
			fullTime = hm.getOrDefault(key , 0);

			sumFee = 0;
			if( fullTime <= fees[0] ){
				answer.add( fees[1] );
			}
			else{
				sumFee = fees[1];
				fullTime -= fees[0];

				sumFee += (fullTime/fees[2])*fees[3];

				if( fullTime%fees[2] != 0 )
					sumFee += fees[3];
				answer.add( sumFee );
			}

		}

		return answer.stream().mapToInt(i->i).toArray();
	}
}
