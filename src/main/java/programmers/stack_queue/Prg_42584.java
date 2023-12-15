package programmers.stack_queue;

public class Prg_42584 {
    public static void main(String[] args) {

        Prg_42584 sol = new Prg_42584();

        int[] ans = sol.solution(new int[]{  1, 2, 3, 2, 3  });

        for( int i : ans )
            System.out.print(i +" ");
        System.out.println();

    }

    private int[] solution( int[] prices ){
        int[] answer = new int[prices.length];

        for( int i =0 ;i < prices.length ;i ++ ){

            int now = prices[i];
            for( int j = i + 1 ; j< prices.length ;j++ ){

                answer[i]++;

                if( now > prices[j] ){
                    break;
                }

            }

        }

        return answer;
    }
}