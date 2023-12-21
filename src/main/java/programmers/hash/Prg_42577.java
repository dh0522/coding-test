package programmers.hash;

import java.util.Arrays;

public class Prg_42577 {
    public static void main(String[] args) {

        Prg_42577 sol = new Prg_42577();
        System.out.println(sol.solution(new String[]{ "119", "97674223", "1195524421" }));
        System.out.println(sol.solution(new String[]{ "123","456","789" }));
        System.out.println(sol.solution(new String[]{ "12","123","1235","567","88" }));
    }

    private boolean solution( String[] phone_book ){
        boolean answer = true;
        Arrays.sort( phone_book );
        for( int i = 0; i < phone_book.length-1 ; i ++ ){

            String head = phone_book[i];

            if( phone_book[i+1].startsWith( head ) )
                return false;

        }

        return answer;
    }
}