package programmers;

public class Prg_43165 {
    public static void main(String[] args) {

        Prg_43165 sol = new Prg_43165();

        System.out.println(sol.solution( new int []{1,1,1,1,1}, 3 ));
    }
    private int answer = 0;
    private int solution(int[] numbers , int target ){

        dfs( 0 , numbers , target , 0 );

        return answer;
    }
    public void dfs( int depth , int[] numbers , int target , int sum ){

        if( depth == numbers.length ){

            if( sum == target )
                answer++;
            return;
        }



        dfs( depth+1 , numbers, target , sum + numbers[depth]  );
        dfs( depth+1 , numbers, target , sum - numbers[depth]  );



    }
}