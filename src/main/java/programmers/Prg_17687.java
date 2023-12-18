package programmers;

public class Prg_17687 {
    public static void main(String[] args) {

        Prg_17687 sol = new Prg_17687();

        System.out.println(sol.solution(2,4,2,1));
        System.out.println(sol.solution(16,16,2,1));
        System.out.println(sol.solution(16,16,2,2));
    }

    private String solution( int n, int t , int m , int p ){
        StringBuilder sb = new StringBuilder();

        int a = 1;
        sb.append(0);

        while( sb.length() < t*m ){

            sb.append( trans( n, a ) ) ;
            a++;

        }

        String ans = "";
        for( int i = 0; i < t ; i++ ){
            ans += sb.substring( p + i*m -1 , p+ i*m );
        }

        return ans;
    }

    private String trans( int n , int num ){

        StringBuilder sb = new StringBuilder();

        while( num > 0 ){

            int res = num % n ;

            if( res >= 10 )
                sb.append( (char)('A' + ( res - 10 ) ) );
            else
                sb.append( res );

            num = num / n;

        }

        return sb.reverse().toString();

    }
}