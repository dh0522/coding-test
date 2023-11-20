package programmers;

import java.util.*;

public class Prg_17684 {
    public static void main(String[] args) {

        Prg_17684 sol = new Prg_17684();
        int[] answer1 = sol.solution("KAKAO");
        for( int i: answer1 )
            System.out.print(i+" ");
        System.out.println();

        int[] answer2 = sol.solution("TOBEORNOTTOBEORTOBEORNOT");
        for(int i: answer2)
            System.out.print(i+" ");
        System.out.println();

        int[] ans3 = sol.solution("ABABABABABABABAB");
        for( int i: ans3 )
            System.out.print(i+" ");
        System.out.println();
    }
    private int[] solution( String msg ){

       HashMap<String, Integer > map = new HashMap<>();
       ArrayList<Integer> anslist = new ArrayList<>();
       for( int i = 0; i< 26; i++ ){
           map.put(Character.toString(i+65),i+1);
       }

        for( int i=0 ;i< msg.length(); i++ ){
            for( int j =1; i + j<= msg.length();j++ ){
                String temp = msg.substring(i, i+j);
                if( !map.containsKey( temp ) ){
                    anslist.add( map.get(temp.substring(0, temp.length()-1 )) );
                    map.put( temp, map.size() +1 );
                    i = i+j -2;
                    break;

                }else if( i + j == msg.length() ){
                    anslist.add( map.get(temp) );
                    i = i + j -1;
                    break;
                }


            }
        }


        int[] ans = new int[ anslist.size() ];
        for( int i =0 ;i< anslist.size(); i++ )
            ans[i] = anslist.get(i);
         return ans;

    }
}
