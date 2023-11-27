package programmers;

public class Prg_12918 {
    public static void main(String[] args) {

        Prg_12918 sol = new Prg_12918();

        System.out.println(sol.solution("a234"));
        System.out.println(sol.solution("1234"));
    }

    private boolean solution(String s){

        if( s.length() == 4 || s.length() == 6 ){

            try{

                int temp = Integer.parseInt(s);
                return true;

            }catch(NumberFormatException ex ){
                return false;
            }

        }
        return false;
    }
}