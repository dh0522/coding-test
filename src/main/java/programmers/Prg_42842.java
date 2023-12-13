package programmers;

public class Prg_42842 {
    public static void main(String[] args) {

        Prg_42842 sol = new Prg_42842();

        int[] ans1 = sol.solution(10,2);
        int[] ans2 = sol.solution(8,1);
        int[] ans3 = sol.solution(24,24);

        for( int i : ans1 )
            System.out.print(i+" ");
        System.out.println();

        for( int i : ans2 )
            System.out.print(i+" ");
        System.out.println();

        for( int i : ans3 )
            System.out.print(i+" ");
        System.out.println();
    }
    private int[] solution( int brown , int yellow ){
        int[] answer = new int[2];

        int sum = brown + yellow ;

        for( int i = 2; i < sum; i++ ){

            if( sum % i != 0 )
                continue;

            int garo = sum/i;
            int sero = i;

            if( garo*2 + (sero-2)*2 == brown ){

                answer[0] = garo;
                answer[1] = sero;
                break;

            }

        }

        return answer;
    }
}
