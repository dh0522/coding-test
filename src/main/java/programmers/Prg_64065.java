package programmers;


import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

public class Prg_64065 {
    public static void main(String[] args) {
        Prg_64065 sol = new Prg_64065();

        int[] ans = sol.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        for( int i : ans )
            System.out.print(i+" ");
        System.out.println();

        int[] ans2 = sol.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
        for( int i : ans2 )
            System.out.print(i+" ");
        System.out.println();

        int[] ans3 = sol.solution("{{20,111},{111}}");
        for( int i : ans3 )
            System.out.print(i+" ");
        System.out.println();

    }

    private int[] solution( String s ) {

        s = s.substring(2,s.length()-2).replace("},{",",,");
        String[] arr = s.split(",,");
        Stack<Integer> stk = new Stack<>();
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        int[] ans = new int[arr.length];
        for( int i =0; i< arr.length; i++){

            if( i == 0 ){
                ans[0] = Integer.parseInt(arr[0]);
                stk.push(ans[0]);
                continue;
            }else{

                String[] tmp = arr[i].split(",");

                int[] temp = new int[tmp.length];
                for( int j=0; j< tmp.length;j++ ){
                    temp[j] = Integer.parseInt(tmp[j]);
                }
                for( int j =0;j<tmp.length; j++ ){
                    if( !stk.contains(temp[j]) ){
                        stk.push(temp[j]);
                        ans[i] = temp[j];
                    }
                }

            }
        }



        return ans;
    }
}
