package programmers;

public class Prg_132267 {
    public static void main(String[] args) {
        Prg_132267 sol = new Prg_132267();

        System.out.println(sol.solution(2,1,20));
        System.out.println(sol.solution(3,1,20));
    }
    private int solution( int a, int b , int n ){
        int answer = 0;

        while( n >= a ){

            answer += (n/a)*b;
            n = n - (n/a)*a + (n/a)*b ;
        }


        return answer;
    }
}
