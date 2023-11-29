package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Prg_12915 {
    public static void main(String[] args) {

        Prg_12915 sol = new Prg_12915();
        String[] ans1 = sol.solution(new String[]{"sun", "bed", "car"},1);
        String[] ans2 = sol.solution(new String[]{"abce", "abcd", "cdx"},2);

        for(String str : ans1)
            System.out.print(str+" ");
        System.out.println();

        for(String str : ans2)
            System.out.print(str+" ");
        System.out.println();
    }
    private String[] solution (String[] strings , int n ){

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                if( o1.charAt(n) > o2.charAt(n) )
                    return 1;
                else if( o1.charAt(n) < o2.charAt(n) )
                    return -1;
                else return o1.compareTo(o2);
            }
        });

        return strings;
    }
}
