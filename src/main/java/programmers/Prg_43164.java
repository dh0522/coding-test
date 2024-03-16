package programmers;

import java.util.*;

public class Prg_43164 {
    public static void main(String[] args) {

        Prg_43164 sol = new Prg_43164();
        String[][] tickets = { { "ICN", "SFO" }, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO" }};
        String[] answer = sol.solution( tickets );

        for( String ans : answer )
            System.out.print( ans +" ");
        System.out.println();


    }
    List<String> candi = new ArrayList<>();
    boolean[] visited ;
    public String[] solution(String[][] tickets) {


        visited = new boolean[tickets.length];

        dfs( tickets , "ICN" , 1 , "ICN" );
        Collections.sort( candi );
        return candi.get(0).split(" ");

    }
    public void dfs( String[][] tickets , String start , int depth , String root ){

        if( depth == tickets.length + 1 ) {
            candi.add( root );
            return;


        }

        for( int i = 0; i< tickets.length; i++ ){

            if( tickets[i][0].equals(start) && !visited[i] ){
                visited[i] = true;
                dfs( tickets , tickets[i][1] , depth+1 , root + " " + tickets[i][1] );
                visited[i] = false;

            }
        }


    }

}