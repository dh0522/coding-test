package programmers;

public class Prg_77885 {
    public static void main(String[] args) {

        Prg_77885 sol = new Prg_77885();
        long[] ans = sol.solution( new long[] {2,7} ) ;
        for(long i : ans )
            System.out.print(i+" ");
        System.out.println();
    }
    private long[] solution(long[] numbers){
        long[] answer = new long[numbers.length];

        for( int i = 0 ; i < numbers.length; i++ ){

            long x = numbers[i];

            // 짝수
            if( x % 2 == 0 ){
                answer[i] = x + 1;
                continue;
            }

            // 홀수

            StringBuilder sb = new StringBuilder( "0"+ Long.toBinaryString(x) );
            for( int j = sb.length() - 2; j >= 0 ; j-- ){
                if( sb.charAt(j) == '0' ){
                    sb.setCharAt(j,'1');
                    sb.setCharAt(j+1,'0');
                    break;
                }

            }

            answer[i] = Long.parseLong( sb.toString() , 2 );

        }

        return answer;
    }
}