package programmers;

public class Prg_12900 {
    public static void main(String[] args) {
        Prg_12900 sol = new Prg_12900();

        System.out.println(sol.solution( 4 ));
    }

    private int solution ( int n ){
        int[] d = new int[600001];

        d[2] = 2;
        d[3] = 3;
        for( int i = 4; i<= n ;i ++ ){
            d[i] = (d[i-1] + d[i-2])%1000000007;
        }

        return d[n];
    }
}
