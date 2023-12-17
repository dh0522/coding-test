package programmers;
import java.util.*;
public class Prg_42888 {
    public static void main(String[] args) {

        Prg_42888 sol = new Prg_42888();

        String[] ans = sol.solution( new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo",
                "Leave uid1234", "Enter uid1234 Prodo","Change uid4567 Ryan"});

        for( String i: ans )
            System.out.print(i+ " ");
        System.out.println();
    }

    private String[] solution (String[] record ){

        HashMap<String , String> hm = new HashMap<>();
        for( int i = 0 ; i< record.length ; i ++ ){

            String[] word = record[i].split(" ");

            if( word[0].equals( "Leave" ) )
                continue;

            hm.put( word[1] , word[2] );

        }

        List<String> list = new ArrayList<>();

        for( int i =0; i < record.length ; i++ ){

            StringBuilder sb = new StringBuilder();
            String[] word = record[i].split(" ");

            if( word[0].equals("Change") )
                continue;
            else if( word[0].equals( "Enter" )){

                sb.append(hm.get(word[1]) + "님이 들어왔습니다.");
            }
            else{
                sb.append(hm.get(word[1]) + "님이 나갔습니다.");
            }

            list.add(sb.toString());
        }

        String[] answer = new String[list.size()];
        list.toArray(answer);

        return answer;
    }
}
