package programmers;
import java.util.*;
public class Prg_120863 {

    public static void main(String[] args) {

        Prg_120863 sol = new Prg_120863();
        System.out.println(sol.solution("3x + 7 + x"));
        System.out.println(sol.solution("x + x + x"));

    }
    private String solution(String polynomial){


        String[] strarr = polynomial.replace(" ","").split("\\+");
        int coeff = 0;
        int constant = 0;

        for( int i =0 ; i <strarr.length ; i++ ){
            String temp = strarr[i];
            if( temp.contains("x") ){
                if( temp.length() == 1){ // 계수 = 1
                    coeff++;
                }else{
                    temp = temp.replace("x","");
                    coeff += Integer.parseInt(temp);
                }
            }else{

                constant += Integer.parseInt(temp);
            }

        }

        String answer= "";
        if(coeff == 1 ){
            if( constant == 0)
                answer = "x";
            else
                answer = "x + "+Integer.toString(constant);
        }
        else if(coeff == 0)
            answer = Integer.toString(constant);
        else if( constant == 0)
            answer = Integer.toString(coeff)+"x";
        else
            answer = Integer.toString(coeff)+"x + "+Integer.toString(constant);
        return answer;
    }
}