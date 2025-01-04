package programmers;

public class Prg_340213 {
	public static void main(String[] args) {
		Prg_340213 sol = new Prg_340213();
		System.out.println(sol.solution( "34:33","13:00", "00:55", "02:55",new String[]{"next", "prev"} ));
	}
	static int opStart = 0;
	static int opEnd = 0;
	private static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
		StringBuilder sb = new StringBuilder();

		int videoLen = Integer.parseInt(video_len.substring(0,2))*60 + Integer.parseInt( video_len.substring(3) );
		int allTime = Integer.parseInt( pos.substring(0,2) )*60 + Integer.parseInt( pos.substring(3)) ;

		opStart = Integer.parseInt(op_start.substring(0,2))*60 + Integer.parseInt( op_start.substring(3) );
		opEnd = Integer.parseInt(op_end.substring(0,2))*60 + Integer.parseInt( op_end.substring(3) );

		for( String command : commands ){

			if( isOpening(allTime) )
				allTime = opEnd;

			if( command.equals("next") )
				allTime += 10;
			else
				allTime -= 10;

			if( isOpening( allTime ) )
				allTime = opEnd;

			if( allTime < 10 )
				allTime = 0;
			else if( allTime + 10 > videoLen )
				allTime = videoLen;

		}

		if( isOpening(allTime) )
			allTime = opEnd;

		int hour = allTime/60;
		int min = allTime%60;


		if( hour <= 9 )
			sb.append(0);
		sb.append(hour).append(":");

		if( min <= 9 )
			sb.append(0);
		sb.append(min);

		return sb.toString();
	}

	private static boolean isOpening( int time ){

		if( opStart <= time && time <= opEnd )
			return true;
		return false;

	}
}
