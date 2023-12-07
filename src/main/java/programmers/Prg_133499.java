package programmers;

public class Prg_133499 {
    public static void main(String[] args) {

        Prg_133499 sol = new Prg_133499();

        System.out.println(sol.solution(new String[]{"aya", "yee", "u", "maa"}));
        System.out.println(sol.solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
    }
    private int solution( String[] babbling ){
        int answer = 0;

        for( int i =0 ; i < babbling.length ; i++ ){

            String word = babbling[i];

            word = word.replaceAll("ayaaya|yeye|woowoo|mama","  ");
            word = word.replaceAll("aya|ye|woo|ma","");

            if( word.equals("") )
                answer++;



        }

        return answer;
    }
}