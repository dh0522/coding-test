package programmers;

import java.util.ArrayList;


public class Prg_17677 {
    public static void main(String[] args) {

        Prg_17677 sol = new Prg_17677();
        System.out.println(sol.solution("FRANCE","french"));
        System.out.println(sol.solution("handshake","shake hands"));
        System.out.println(sol.solution("aa1+aa2","AAAA12"));
        System.out.println(sol.solution("E=M*C^2","e=m*c^2"));

    }
    private int solution( String str1, String str2 ){
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        for( int i = 0; i< str1.length()-1; i++ ){
            char one = str1.charAt(i);
            char two = str1.charAt(i+1);
            if( 'a'<= one && one <= 'z' && 'a' <= two && two<= 'z' ){
                String tmp = String.valueOf(one)+String.valueOf(two);
                list1.add(tmp);
            }
        }

        for( int i=0; i<str2.length()-1; i++ ){
            char one = str2.charAt(i);
            char two = str2.charAt(i+1);
            if( 'a'<= one && one <= 'z' && 'a' <= two && two<= 'z' ){
                String tmp = String.valueOf(one)+String.valueOf(two);
                list2.add(tmp);
            }
        }

        int inter = 0;
        int allnum = list1.size()+ list2.size();
        for( String tmpstr : list1 ){
            for( String tmpstr2 :list2 ){
                if( tmpstr.equals(tmpstr2) ){
                    inter++;
                    list2.remove(tmpstr2);
                    break;
                }
            }

        }

        allnum = allnum- inter;

        int answer = 0;

        if(list1.size() == 0 && list2.size() == 0)
            return 65536;
        else answer= (int) ((double) inter/allnum*65536);

        return answer;
    }
}
