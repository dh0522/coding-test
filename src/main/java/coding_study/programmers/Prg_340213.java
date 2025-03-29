package coding_study.programmers;

public class Prg_340213 {
	public static void main(String[] args) {
		Prg_340213 sol = new Prg_340213();

		System.out.println(sol.solution("34:33","13:00","00:55","02:55", new String[]{"next", "prev"}));
	}
	private static int opStart, opEnd;
	private static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

		String[] nowTime = pos.split(":");
		int now = Integer.parseInt(nowTime[0])*60 + Integer.parseInt(nowTime[1]);

		String[] opStartTime = op_start.split(":");
		opStart = Integer.parseInt(opStartTime[0])*60 + Integer.parseInt(opStartTime[1]);

		String[] opEndTime = op_end.split(":");
		opEnd = Integer.parseInt(opEndTime[0])*60 + Integer.parseInt(opEndTime[1]);

		String[] videoLen = video_len.split(":");
		int fullLen = Integer.parseInt(videoLen[0])*60 + Integer.parseInt(videoLen[1]);


		for(String command: commands){

			if(isOpening(now)){
				now = opEnd;
			}

			if(command.equals("prev")){
				now = now - 10 > 10 ?  now-10 : 0;

			}else if(command.equals("next")){
				now = now + 10 <= fullLen -10 ? now + 10 : fullLen;
			}

			if(isOpening(now)){
				now = opEnd;
			}

		}


		String hour = String.valueOf(now/60);
		String min = String.valueOf(now%60);

		if( hour.length() == 1 ){
			hour = "0"+hour;
		}
		if(min.length() == 1){
			min = "0"+min;
		}


		return hour+":"+min;
	}

	private static boolean isOpening(int now){
		if( opStart <= now && now <= opEnd ){
			return true;
		}

		return false;
	}
}
