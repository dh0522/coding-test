package programmers;
import java.util.*;
public class Prg_17686 {
    public static void main(String[] args) {
        Prg_17686 sol = new Prg_17686();

        String[] ans1 = sol.solution( new String[] { "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" });
        String[] ans2 = sol.solution( new String[] { "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat" });

        for( String i : ans1 )
            System.out.print(i+" ");
        System.out.println();

        for( String i : ans2 )
            System.out.print(i+" ");
        System.out.println();
    }
    private String[] solution( String[] files ){


        Arrays.sort( files , new Comparator<String>() {

            @Override
            public int compare( String o1, String o2 ){

                String head1 = o1.split("[0-9]")[0].toLowerCase();
                String head2 = o2.split("[0-9]")[0].toLowerCase();



                if( head1.compareTo(head2) == 0 ){

                    int number1 = num( o1 , head1 );
                    int number2 = num( o2 , head2 );

                    return (number1 - number2) ;
                }

                return head1.compareTo(head2);
            }

        });

        return files;
    }
    public int num( String file , String head ){

        // file  img12.png
        int length = head.length();
        String temp = "";

        for( int i = length; i < file.length() ;i++ ){

            if( Character.isDigit( file.charAt(i) ) ){
                temp+= file.charAt(i);
            }else
                break;
        }

        return Integer.parseInt(temp);
    }
}