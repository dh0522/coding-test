package programmers;
import java.util.*;
public class Prg_155651 {
    public static void main(String[] args) {

        Prg_155651 sol = new Prg_155651();

        String[][] book_time = {{ "15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"  }};
        System.out.println(sol.solution(book_time));
    }
    private int solution( String[][] book_time ){

        int[][] booktime = new int[book_time.length][2];

        for( int i = 0 ; i < book_time.length ;i++ ){
            // 60 분인거 잊으면 안됌
            int startTime = Integer.parseInt(book_time[i][0].replace(":",""));
            int endTime = Integer.parseInt(book_time[i][1].replace(":","") ) +  10;

            if( endTime % 100 >= 60 ){
                endTime += (100 - 60);
            }
            booktime[i][0] = startTime;
            booktime[i][1] = endTime;

        }

        Arrays.sort( booktime , (o1,o2) ->{
            return (o1[0] - o2[0]);
        });

        ArrayList<Integer> list = new ArrayList<>();

        for( int i = 0; i < booktime.length ; i++ ){

            Collections.sort(list);

            if( i == 0 ){
                list.add(booktime[i][1]);
                continue;
            }

            int nowstart = booktime[i][0];

            if( list.get(0) <= nowstart ){
                list.remove(0);
                list.add( booktime[i][1] );

            }else
                list.add(booktime[i][1]);

        }

        return list.size();
    }
}