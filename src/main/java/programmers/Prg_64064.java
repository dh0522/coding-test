package programmers;

import java.util.Arrays;
import java.util.HashSet;

public class Prg_64064 {
    public static void main(String[] args) {
        Prg_64064 sol = new Prg_64064();

        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"*rodo", "*rodo", "******"};


        System.out.println(sol.solution(user_id,banned_id));
    }

    boolean[] visited;
    HashSet<String> answer;

    private int solution(String[] user_id, String[] banned_id) {

        answer = new HashSet<>();
        visited = new boolean[user_id.length];

        dfs( user_id , banned_id  , 0 , "" );

        return answer.size();
    }

    private void dfs ( String[] user_id , String[] banned_id , int depth  , String result ){

        if( depth == banned_id.length ){

            String[] tmp = result.split(" ");
            Arrays.sort( tmp );

            String temp = "";

            for( String ans : tmp )
                temp += ans;
            answer.add( temp );

            return;
        }



        for( int j = 0 ; j < user_id.length; j ++ ){

            String banid = banned_id[depth];
            String userid = user_id[j];

            if( isSame(userid , banid) && !visited[j] ){
                visited[j] = true;
                dfs( user_id , banned_id , depth+1  , result + " " + userid );
                visited[j] = false;
            }
        }

    }
    private boolean isSame( String userid , String banid ){

        if( userid.length() != banid.length() )
            return false;

        char[] user = userid.toCharArray();
        char[] ban = banid.toCharArray();

        for( int i = 0 ; i < userid.length() ; i ++ ){

            if( user[i]!= ban[i] && ban[i] != '*' )
                return false;
        }

        return true;
    }
}