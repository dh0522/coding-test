package programmers;

public class Prg_12926 {
    public static void main(String[] args) {

        Prg_12926 sol = new Prg_12926();
        System.out.println(sol.solution("AB",1));
        System.out.println(sol.solution("z",1));
        System.out.println(sol.solution("a B z",4));
    }

    private String solution(String s ,int n ){
        String answer = "";

        for( int i = 0; i< s.length(); i++ ){

            char one = s.charAt(i);

            if( Character.isUpperCase(one) ){

                if( one + n > 'Z' ){
                    one = (char)(one + n - 'Z' + 'A' -1 );
                }
                else
                    one += n;
                answer += String.valueOf( one );


            }else if( Character.isLowerCase(one) ){

                if( one + n > 'z' ){
                    one = (char) (one + n - 'z' + 'a' -1 );
                }
                else
                    one += n;
                answer += String.valueOf(one);

            }else{
                answer += one;
            }
        }

        return answer;
    }
}