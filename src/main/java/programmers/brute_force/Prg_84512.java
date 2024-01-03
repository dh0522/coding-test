package programmers.brute_force;

public class Prg_84512 {
    public static void main(String[] args) {

        Prg_84512 sol = new Prg_84512() ;

        System.out.println(sol.solution( "AAAE"));

    }
    static int idx = 0;
    static int answer = -1;
    private int solution(String word) {


        dfs(word , "");
        return answer;
    }
    private void dfs ( String word, String now ){

        if( now.length() > 5 )
            return;

        if( word.equals( now ) ){
            answer = idx;
            return;
        }

        idx ++;

        dfs( word, now +"A");
        dfs( word, now +"E");
        dfs( word, now +"I");
        dfs( word, now +"O");
        dfs( word, now +"U");

    }

}