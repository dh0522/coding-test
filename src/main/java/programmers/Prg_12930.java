package programmers;

public class Prg_12930 {
    public static void main(String[] args) {

        Prg_12930 sol = new Prg_12930();
        System.out.println(sol.solution("try hello world"));
    }
    private String solution( String s ){
        String answer = "";

        String[] words = s.split(" ",-1);

        for( int i=0; i<words.length; i++ ){

            String word = words[i];
            for( int j =0; j< word.length(); j++ ){

                if( j % 2 == 0 )
                    answer += String.valueOf(word.charAt(j)).toUpperCase() ;
                else
                    answer += String.valueOf(word.charAt(j)).toLowerCase();

            }
            if(i != words.length -1 )
                answer += " ";
        }

        return answer;
    }
}