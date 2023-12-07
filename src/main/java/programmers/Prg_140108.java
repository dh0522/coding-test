package programmers;

public class Prg_140108 {
    public static void main(String[] args) {

        Prg_140108 sol = new Prg_140108();

        System.out.println(sol.solution("banana"));
        System.out.println(sol.solution("abracadabra"));
        System.out.println(sol.solution("aaabbaccccabba"));
    }

    private int solution(String s){
        int answer = 0;

        while( s.length() != 0 ){

            if( s.length()  == 1 ){
                answer++;
                break;
            }

            char first = s.charAt(0);

            int chnum = 1;
            int notnum = 0;

            for( int i = 1; i< s.length(); i++ ){

                if( first != s.charAt(i) ) {
                    notnum++;
                }
                else
                    chnum++;

                if( chnum == notnum ){
                    answer++;
                    s = s.substring(i+1);
                    break;
                }
                if( i == s.length()-1 ){
                    answer++;
                    s="";
                }
            }
        }

        return answer;
    }
}