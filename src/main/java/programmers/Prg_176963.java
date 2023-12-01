package programmers;
import java.util.*;
public class Prg_176963 {
    public static void main(String[] args) {

        Prg_176963 sol = new Prg_176963();
        int[] answer1 = sol.solution(new String[]{"may", "kein", "kain", "radi"}, new int[]{5, 10, 1, 3},
                new String[][]{{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}});
        int[] answer2 = sol.solution(new String[]{"kali", "mari", "don"}, new int[]{11, 1, 55},
                new String[][]{{"kali", "mari", "don"}, {"pony", "tom", "teddy"}, {"con", "mona", "don"}});
        int[] answer3 = sol.solution(new String[]{"may", "kein", "kain", "radi"}, new int[]{5, 10, 1, 3},
                new String[][]{{"may"},{"kein", "deny", "may"}, {"kon", "coni"}});



        for( int i: answer1 )
            System.out.print(i+" ");
        System.out.println();

        for( int i: answer2 )
            System.out.print(i+" ");
        System.out.println();

        for( int i: answer3 )
            System.out.print(i+" ");
        System.out.println();
    }

    private int[] solution( String[] name , int[] yearning , String[][] photo){
        int[] answer = new int[photo.length];

        HashMap<String,Integer> hm = new HashMap<>();
        for( int i = 0 ;i < name.length; i++ )
            hm.put(name[i],yearning[i]);

        for( int i =0 ;i < photo.length ; i++ ){

            for( int j =0 ; j < photo[i].length; j++ ){
                if( hm.containsKey(photo[i][j]) )
                    answer[i] += hm.get(photo[i][j]);
            }

        }

        return answer;
    }
}