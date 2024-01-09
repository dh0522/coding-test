package programmers;

public class Prg_148653 {
    public static void main(String[] args) {
        Prg_148653 sol = new Prg_148653();
        System.out.println(sol.solution( 16));
        System.out.println(sol.solution(2554));
        System.out.println(sol.solution(95));

    }
    private int solution( int storey ){
        int answer = 0;

        while( storey != 0 ){


            int res = storey % 10 ;
            if( res > 5 ){

                answer += ( 10 - res );
                storey += ( 10 - res );
                storey /= 10 ;


            }else if( res < 5 ){
                // 13
                answer += res;
                storey -= res;
                storey /= 10;


            }else{
                // 2995
                int ex = (storey%100)/10 ;
                if( ex >= 5 ){
                    storey += 10;
                }
                answer +=5;
                storey/= 10;
            }


        }

        return answer;
    }
}