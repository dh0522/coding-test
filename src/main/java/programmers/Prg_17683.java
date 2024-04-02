package programmers;

public class Prg_17683 {
	public static void main(String[] args) {

		Prg_17683 sol = new Prg_17683();

		String m ="ABCDEFG";
		String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF" };

		System.out.println(sol.solution( m , musicinfos));

		String[] musicinfos1 = {"12:00,12:06,HELLO,ABC#ABC#ABC"};

		System.out.println(sol.solution(m, musicinfos1));
	}
	private String solution( String m , String[] musicinfos ){
		String answer = "";

		String[][] musicinfo = new String[musicinfos.length][4];
		int play = -1;
		for( int i = 0 ; i< musicinfos.length; i++ ){

			String info = musicinfos[i];
			String M = m.replace("C#","c").replace("D#","d").replace("F#","f")
				.replace("G#","g").replace("A#","a");

			musicinfo[i] = info.split(",");

			String[] start = musicinfo[i][0].split(":");
			String[] end = musicinfo[i][1].split(":");

			int time  = (Integer.parseInt(end[0])*60 + Integer.parseInt(end[1] ))
				- ((Integer.parseInt(start[0])*60) + Integer.parseInt(start[1])) ;

			String music  = musicinfo[i][3];

			if( musicinfo[i][3].contains("#") ){
				music = music.replace("C#","c").replace("D#","d").replace("F#","f")
					.replace("G#","g").replace("A#","a");
			}


			int repeat = time / music.length();

			StringBuilder sb = new StringBuilder();

			if( repeat == 0 ){
				sb.append( music.substring(0,time));
			}else{
				for( int j = 0; j<= repeat; j++ )
					sb.append(music);
			}

			String temp = sb.toString();
			if( temp.contains(M) && play < time ){

				answer = musicinfo[i][2];
				play = time;

			}

		}

		if( answer == "" )
			answer = "(None)";


		return answer;
	}
}
