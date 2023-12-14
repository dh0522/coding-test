package programmers;

public class Prg_12914 {
    public static void main(String[] args) {
        Prg_12914 sol = new Prg_12914();

        System.out.println(sol.solution(4));
        System.out.println(sol.solution(3));
    }

    private long solution( int n ){
        long[] arr = new long[2001];

        arr[1] = 1;
        arr[2] = 2;

        for( int i = 3; i<= n ;i ++ )
            arr[i] = (arr[i-1] + arr[i-2])%1234567;

        return arr[n];
    }
}