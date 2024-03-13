package programmers.dfsbfs;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class Prg_43163 {
    public static void main(String[] args) {
        Prg_43163 sol = new Prg_43163();

        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(sol.solution("hit","cog",words));
    }
    boolean[] visited ;
    private int solution(String begin, String target, String[] words) {


        List<String> list = new ArrayList<>(Arrays.asList(words));
        visited = new boolean[words.length];

        if( !list.contains(target ) )
            return 0;


        return findRoot ( list , begin , target );
    }

    private int findRoot( List<String> list , String begin, String target ){

        int num = 0;

        Stack<String> stk = new Stack<>();

        stk.push( begin );

        while( !stk.isEmpty() ){

            String now = stk.pop();

            for( int i = 0 ; i < list.size() ; i ++ ){

                String temp = list.get(i);

                if( isDifferentOne( now , target) ){
                    return num+1;
                }

                if( isDifferentOne( now , temp ) && !visited[i] ){

                    num++;
                    stk.push( temp );
                    visited[i] = true;
                    break;
                }

            }

        }
        return num;
    }

    private boolean isDifferentOne( String begin , String target ){

        int num = 0;

        for( int i = 0; i < begin.length(); i++ ){
            if( begin.charAt(i) == target.charAt(i) )
                continue;
            num++;
        }

        if( num == 1 )
            return true;
        return false;

    }
}



