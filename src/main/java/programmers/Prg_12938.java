package programmers;

public class Prg_12938 {
    public static void main(String[] args) {
        Prg_12938 sol = new Prg_12938();

        int[] ans1 = sol.solution( 2 , 9 );
        for( int i : ans1 )
            System.out.print(i+" ");
        System.out.println();


        int[] ans2 = sol.solution( 2 , 1 );
        for( int i : ans2 )
            System.out.print(i+" ");
        System.out.println();


        int[] ans3 = sol.solution( 2 , 8 );
        for( int i : ans3 )
            System.out.print(i+" ");
        System.out.println();
    }
    private int[] solution( int n , int s ){

        if( n > s )
            return new int[]{-1};

        int[] answer = new int[n];
        int idx = 0;

        while( n > 0 ){

            int max = s/n;
            answer[idx++] = max;
            s -= max;
            n--;

        }


        return answer;
    }
}