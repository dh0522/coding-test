package programmers;

public class Prg_12901 {
    public static void main(String[] args) {

        Prg_12901 sol = new Prg_12901();

        System.out.println(sol.solution(5,24));
        System.out.println(sol.solution(5,5));
    }
    private String solution(int a , int b){
        String[] day = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int[] month = {31,29,31,30,31,30,31,31,30,31,30,31};

        int days = 0;
        for(int i = 0; i < a-1 ; i++ )
            days += month[i];
        days += b;


        if(days % 7 == 0  )
            return "THU";

        return day[ days%7 -1];

    }
}